package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest extends BaseTest
{
    private static List<String> addedFavorite;
    @Test
    @Order(1)
    public void loginTest(){
        new LoginPage().login();
    }
    @Test
    @Order(2)
    public void searchProductTest(){
        new HomePage().searchProduct("oyuncak");
    }
    @Test
    @Order(3)
    public void addToFavoriteTest()
    {
        SearchedProductPage searchedProductPage=new SearchedProductPage();
        searchedProductPage.scrollProdSearchedProductByIndex(7);
        addedFavorite=searchedProductPage.addToFavoriteRandomly(4);
    }
    @Test
    @Order(4)
    public void checkFavoriteTest()
    {
        HomePage homePage=new HomePage();

        homePage.navigateToFavoritePage();
        new FavoritePage().checkFavorite(addedFavorite);

        homePage.navigateToHomePage();
        homePage.navigateToPointsCatalog();
        new PointsCatalogPage().selectOptionsInPointsCatalog("Türk Klasikleri");
        new ProductPageByCategory().selectOrder("Yüksek Oylama");
        homePage.selectOptionsInAllBooks("Hobi");
    }

    @Test
    @Order(5)
    public void addRandomProductTest(){
        new ProductPageByCategory().addRandomProduct();
    }
    @Test
    @Order(6)
    public void removeFromFavoriteTest(){
        new HomePage().navigateToFavoritePage();
        new FavoritePage().removeProdFromFav(addedFavorite.get(2));
    }
    @Test
    @Order(7)
    public void changeProductQuantityTest(){
        BasketPage basketPage=new BasketPage();
        new HomePage().navigateToBasket();
        basketPage.changeProductQuantity("5");
        basketPage.clickToBuy();
    }
    @Test
    @Order(8)
    public void cargoInformationTest(){
        CargoPage cargoPage=new CargoPage();
        cargoPage.clickNewAddress();
        cargoPage.sendName("furkan");
        cargoPage.sendLastName("sar");
        cargoPage.selectCountry("215");
        cargoPage.selectCity("3354");
        cargoPage.selectCounty("462");
        cargoPage.sendAddress("deneme");
        cargoPage.sendPostalCode("343434");
        cargoPage.sendMobilePhone("5123456789");
        cargoPage.sendAddressTelephone("2123456789");
        cargoPage.clickContinue();
        new CargoMethodPage().clickToContinue();
    }

    @Test
    @Order(9)
    public void paymentInformationTest(){
        PaymentPage paymentPage=new PaymentPage();
        paymentPage.setCardName("Sabahattin Ali");
        paymentPage.setCardNumber("5937182926238162");
        paymentPage.selectExpireDate("03","2023");
        paymentPage.sendCVV("568");
    }
    @Test
    @Order(10)
    public void logoutTest(){
        PaymentPage paymentPage=new PaymentPage();
        paymentPage.clickToContinue();
        paymentPage.clickLogo();
        new HomePage().logout();
    }
}
