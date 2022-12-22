package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class PointsCatalogPage {
    Logger logger= LogManager.getLogger(PointsCatalogPage.class);
    Method method;
    public PointsCatalogPage(){
        method=new Method();
    }
    public void selectOptionsInPointsCatalog(String option){
        method.clickJS(By.xpath("//img[@title='Puan Kataloğundaki "+option+"']"));
        Assertions.assertTrue(method.isElementVisible(By.xpath("//div[@class='breadcrumb']//a[text()='"+option+"']")),option+" sayfasina yonlendirilemedi");
        logger.info(option+" sıralaması secildi");
    }
}
