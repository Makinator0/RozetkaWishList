package org.example.Page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RozetkaSearchPage {
    private WebDriver driver;

    public RozetkaSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Find the specific MacBook product and add to wishlist")
    public void addMacBook2022ToWishlist() throws InterruptedException {
        Thread.sleep(2000);
        WebElement productTile = driver.findElement(By.xpath("/html/body/rz-app-root/div/div/rz-main-page/div/main/rz-main-page-content/rz-goods-sections/section[1]/rz-goods-section/ul/li[1]/rz-app-tile/div/div"));
        WebElement wishlistButton = productTile.findElement(By.xpath("/html/body/rz-app-root/div/div/rz-main-page/div/main/rz-main-page-content/rz-goods-sections/section[1]/rz-goods-section/ul/li[1]/rz-app-tile/div/div/div[1]/rz-wishlist-add-simple-button/div/button"));
        wishlistButton.click();
    }
    @Step("Find the specific MacBook product and add to wishlist")
    public void addMacBook2020ToWishlist() throws InterruptedException {
        Thread.sleep(2000);
        WebElement productTile = driver.findElement(By.xpath("/html/body/rz-app-root/div/div/rz-main-page/div/main/rz-main-page-content/rz-goods-sections/section[1]/rz-goods-section/ul/li[2]/rz-app-tile/div/div"));
        WebElement wishlistButton = productTile.findElement(By.xpath("/html/body/rz-app-root/div/div/rz-main-page/div/main/rz-main-page-content/rz-goods-sections/section[1]/rz-goods-section/ul/li[2]/rz-app-tile/div/div/div[1]/rz-wishlist-add-simple-button/div/button"));
        wishlistButton.click();
    }
    public void  openWishlist() throws InterruptedException {
        Thread.sleep(2000);
        WebElement wishlistButton = driver.findElement(By.xpath("/html/body/rz-app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-wishlist-header-button/a"));
        wishlistButton.click();

    }
}