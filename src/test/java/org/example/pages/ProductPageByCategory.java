package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageByCategory {

    Method method;
    Logger logger= LogManager.getLogger(ProductPageByCategory.class);
    HomePage staticPage;
    public ProductPageByCategory(){
        method=new Method();
    }
    public void selectOrder(String orderType){
        method.selectByText(By.cssSelector(".sort>select"),orderType);
    }
   public void addRandomProduct(){
        staticPage=new HomePage();
        List<WebElement> productList=method.getList(By.cssSelector(".product-grid.jcarousel-skin-opencart"),By.cssSelector(".product-cr"));
        WebElement randomProduct=productList.get(method.giveRandomNumber(productList.size()-1));
        method.clickJS(randomProduct.findElement(By.cssSelector(".add-to-cart")));
        logger.info("urun sepete eklendi");
    }

}
