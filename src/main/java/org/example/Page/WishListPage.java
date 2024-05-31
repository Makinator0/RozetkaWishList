package org.example.Page;

import io.qameta.allure.Step;
import org.example.ProductInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WishListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    @Step("Navigate to the Wishlist page")
    public void  ShowWishList() throws InterruptedException {
        Thread.sleep(3000);
        WebElement wishlistButton = driver.findElement(By.xpath("//*[@id=\"cabinet-content\"]/rz-wishlist-list/div[2]/div/rz-wishlist-header/div/a"));
        wishlistButton.click();

    }

    @Step("Extract product information from the wishlist")
    public List<ProductInfo> getWishListProducts() {
        List<ProductInfo> products = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".goods-tile__content")));
        List<WebElement> wishlistItems = driver.findElements(By.cssSelector(".goods-tile__content"));

        for (WebElement item : wishlistItems) {
            String productName = item.findElement(By.cssSelector(".goods-tile__title")).getText();
            String productPrice = item.findElement(By.cssSelector(".goods-tile__price-value")).getText();
            String availability = item.findElement(By.cssSelector(".goods-tile__availability")).getText();

            products.add(new ProductInfo(productName, productPrice, availability));
        }
        return products;
    }
}
