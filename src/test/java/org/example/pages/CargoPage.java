package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CargoPage {
    Method method;
    Logger logger= LogManager.getLogger(CargoPage.class);
    public CargoPage(){
        method=new Method();
    }
    public void sendName(String name){
        method.sendKeys(By.id("address-firstname-companyname"),name);
        Assertions.assertEquals(name,method.getValue(By.cssSelector("input#address-firstname-companyname"))," ad alani girilemedi");
        logger.info("Ad/Sirket Ad: "+name+" degeri girildi");
    }
    public void sendLastName(String lastName){
        method.sendKeys(By.cssSelector("input#address-lastname-title"),lastName);
        Assertions.assertEquals(lastName,method.getValue(By.cssSelector("input#address-lastname-title"))," ad alani girilemedi");
        logger.info("Soyad/Unvan: "+lastName+" degeri girildi");
    }
    public void selectCountry(String country){
        method.isElementVisible(By.cssSelector("#address-country-id>option[value='"+country+"']"));
        method.selectByValue(By.cssSelector("select#address-country-id"),country);
        Assertions.assertEquals(country,method.getValue(By.cssSelector("select#address-country-id")),"Ulke degeri girilemedi");
        logger.info("Ülke: "+country+" olarak girildi");
    }
    public void selectCity(String city){
        method.isElementVisible(By.cssSelector("#address-zone-id>option[value='"+city+"']"));
        method.selectByValue(By.cssSelector("select#address-zone-id"),city);
        Assertions.assertEquals(city,method.getValue(By.cssSelector("select#address-zone-id")),"Sehir değeri girilemedi");
        logger.info("Sehir: "+city+" olarak girildi");
    }
    public void selectCounty(String value){
        method.isElementVisible(By.cssSelector("#address-county-id>option[value='"+value+"']"));
        method.selectByValue(By.cssSelector("select#address-county-id"),value);
        Assertions.assertEquals(value,method.getValue(By.cssSelector("select#address-county-id")),"Ilce degeri girilemedi");
        logger.info("Ilce: "+value+" index olarak girildi");
    }
    public void sendAddress(String address){
        method.sendKeys(By.cssSelector("textarea#address-address-text"),address);
        Assertions.assertEquals(address,method.getValue(By.cssSelector("textarea#address-address-text"))," ad alani girilemedi");
        logger.info("Adres: "+address+" degeri girildi");
    }
    public void sendPostalCode(String postalCode){
        method.sendKeys(By.cssSelector("input#address-postcode"),postalCode);
        Assertions.assertEquals(postalCode,method.getValue(By.cssSelector("input#address-postcode"))," ad alani girilemedi");
        logger.info("Posta Kodu: "+postalCode+" degeri girildi");
    }
    public void sendMobilePhone(String mobilePhone){
        method.sendKeys(By.cssSelector("input#address-mobile-telephone"),mobilePhone);
        Assertions.assertEquals(mobilePhone,method.getValue(By.cssSelector("input#address-mobile-telephone"))," ad alani girilemedi");
        logger.info("Cep Telefonu: "+mobilePhone+" degeri girildi");
    }
    public void sendAddressTelephone(String landPhone){
        method.sendKeys(By.cssSelector("input#address-telephone"),landPhone);
        Assertions.assertEquals(landPhone,method.getValue(By.cssSelector("input#address-telephone"))," ad alani girilemedi");
        logger.info("Sabit Telefon: "+landPhone+" degeri girildi");
    }
    public void clickNewAddress(){
        if(method.isElementVisible(By.xpath("//a[@href='#tab-shipping-new-adress']"))){
            method.clickJS(By.xpath("//a[@href='#tab-shipping-new-adress']"));
            Assertions.assertTrue(method.isElementVisible(By.cssSelector("input#address-firstname-companyname"))," kargo adres sayfasina yonlendirilemedi");
            logger.info("Kargo adresi sayfasina yonlendirildi");
        }
    }
    public void clickContinue(){
        method.clickJS(By.cssSelector("button#button-checkout-continue"));
        Assertions.assertTrue(method.isElementVisible(By.id("tab-shipping-companies-non"))," kargo metodu sayfasina yonlendirilemedi");
        logger.info("Kargo metodu sayfasina yonlendirildi");
    }
}
