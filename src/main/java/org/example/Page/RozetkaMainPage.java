package org.example.Page;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;


public class RozetkaMainPage {
    private WebDriver driver;

    public RozetkaMainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate to Rozetka home page")
    public void navigateToHomePage() {
        driver.get("https://www.rozetka.com.ua/");
    }

    @Step("Click on the user button")
    public void clickUserButton() throws InterruptedException {
        WebElement userButton = driver.findElement(By.xpath("/html/body/rz-app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[3]/rz-user/button"));
        userButton.click();
        Thread.sleep(2000);
    }

    @Step("Click on the Facebook button")
    public void clickFacebookButton() {
        WebElement facebookButton = driver.findElement(By.xpath("/html/body/rz-app-root/rz-single-modal-window/div[3]/div[2]/rz-auth-phone-enter/rz-auth-wrapper/div/div[1]/rz-auth-social/div/button[3]"));
        facebookButton.click();
    }

    @Step("Enter email and password, then click login button")
    public void login(String email, String password) throws InterruptedException {
        String currentWindowHandle = driver.getWindowHandle();
        switchToNewWindow(driver);

        WebElement emailInput = driver.findElement(By.xpath("//*[@id='email']"));
        Thread.sleep(5000);
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id='pass']"));
        Thread.sleep(5000);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginbutton']"));
        Thread.sleep(5000);
        loginButton.click();
        Thread.sleep(15000);


        if (driver.getWindowHandles().contains(currentWindowHandle)) {
            driver.switchTo().window(currentWindowHandle);
        } else {
            System.out.println("Окно уже было закрыто");
        }
    }

    public static void switchToNewWindow(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
