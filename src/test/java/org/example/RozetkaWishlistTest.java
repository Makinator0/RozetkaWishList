package org.example;

import org.example.Page.RozetkaSearchPage;
import org.example.Page.WishListPage;
import org.testng.annotations.Test;

import java.util.List;

public class RozetkaWishlistTest extends BaseTest {
    @Test
    public void testSearchAndAddToWishlist() throws InterruptedException {
        RozetkaSearchPage searchPage = new RozetkaSearchPage(driver);
        searchPage.addMacBook2022ToWishlist();
        searchPage.addMacBook2020ToWishlist();
        searchPage.openWishlist();
    }
    @Test
    public void testWishlistInfo() throws InterruptedException {
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.ShowWishList();
        List<ProductInfo> products = wishListPage.getWishListProducts();
        for (ProductInfo product : products) {
            System.out.println("Інформація про товари:");
            System.out.println("Назва: " + product.getName());
            System.out.println("Ціна: " + product.getPrice());
            System.out.println("Наявність: " + product.getAvailability());
        }
    }

}
