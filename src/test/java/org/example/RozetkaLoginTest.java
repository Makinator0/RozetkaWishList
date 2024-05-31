package org.example;

import io.qameta.allure.Step;
import org.example.Page.RozetkaMainPage;
import org.testng.annotations.Test;


public class RozetkaLoginTest extends BaseTest{
    @Step("Test login functionality")
    @Test
    public void testLogin() throws InterruptedException {
        User user = UserFactory.getDefaultUser();
        RozetkaMainPage homePage = new RozetkaMainPage(driver);
        homePage.navigateToHomePage();
        homePage.clickUserButton();
        homePage.clickFacebookButton();
        homePage.login(user.getEmail(), user.getPassword());
    }

}
