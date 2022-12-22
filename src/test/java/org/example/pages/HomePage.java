package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.BaseTest;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage {
    Logger logger= LogManager.getLogger(HomePage.class);
    Method method;
    public HomePage(){
        method=new Method();
    }
    public void navigateToHomePage(){
        method.clickJS(By.cssSelector("a[href='https://www.kitapyurdu.com/']"));
        Assertions.assertEquals(BaseTest.ANASAYFA_URL,method.getCurrentURL(),"Anasayfaya yonlendirilemedi");
        logger.info("Anasayfaya yonlendirildi");
    }
    public void navigateToFavoritePage(){
        method.clickJS(method.findElement(By.xpath("//a[text()='Favorilerim']")));
        Assertions.assertTrue(method.isElementVisible(By.xpath("//h1[text()='Favorilerim']")),"Favorilerim sayfasi acilamadi");
        logger.info("Favorilerim sayfasina yonlendirildi");
    }

    public void navigateToPointsCatalog(){
        method.clickJS(By.cssSelector(".common-sprite[href='puan-katalogu']"));
        Assertions.assertEquals("https://www.kitapyurdu.com/puan-katalogu",method.getCurrentURL()," puan kataloguna yonlendirilemedi");
        logger.info("Puan katalogu sayfasina yonlendirildi");
    }

    public void selectOptionsInAllBooks(String text){
        method.scrollWithAction(By.xpath("//span[@class='mn-strong common-sprite' and text()='Tüm Kitaplar']"));
        method.clickJS(method.findElement(By.xpath("//a[@class='mn-icon icon-angleRight' and text()='"+text+"']")));
        Assertions.assertTrue(method.isElementVisible(By.xpath("//h1[text()='"+text+"']"))," Tum kitaplar>"+text+"'e yonlendirilemedi");
        logger.info(new StringBuilder().append("Tum kitaplar>").append(text).append(" yonlendirildi."));
    }
    public void searchProduct(String productName)
    {
        method.sendKeys(By.cssSelector("input[id='search-input']"),productName);
        method.clickJS(By.cssSelector(".common-sprite.button-search"));
        Assertions.assertTrue(method.isElementVisible(By.xpath("//h1[@class='search-heading-title']//span[text()='"+productName+"']")),productName+" urunu aratilamadi");
        logger.info(productName+" urunu aratildi");
    }
    public void navigateToBasket(){
        method.clickJS(By.cssSelector("#cart-items-text-container"));
        method.clickJS(method.findElement(By.cssSelector("#js-cart")));
        Assertions.assertTrue(method.isElementVisible(By.xpath("//a[text()='Sepetim']"))," sepete yonlendirilemedi");
        logger.info("Sepete yonlendirildi");
    }
    public void logout(){
        method.clickJS(By.xpath("//div[@class='menu top login']//a[text()='Çıkış']"));
        Assertions.assertTrue(method.isElementVisible(By.xpath("//div[@class='menu-top-button login']//a[text()='Giriş Yap']")));
        logger.info("Cikis yapildi");

    }
}
