package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchedProductPage {
    Logger logger= LogManager.getLogger(SearchedProductPage.class);
    Method method;
    public SearchedProductPage(){
        method=new Method();
    }

    public void scrollProdSearchedProductByIndex(int index){
        List<WebElement> productList=method.findElementList(By.cssSelector(".product-list"),By.cssSelector(".product-cr"));
        method.scrollWithJS(productList.get(index-1));
        logger.info(index+" .urune scroll yapildi");
    }
    public List<String> addToFavoriteRandomly(int numberOfProduct){
        List<WebElement> productList=method.findElementList(By.cssSelector(".product-list"),By.cssSelector(".product-cr"));
        Collections.shuffle(productList);
        productList.subList(numberOfProduct,productList.size()).clear();
        List<String> productsIDs=new ArrayList<>();
        for(WebElement product:productList){
            method.clickJS(product.findElement(By.cssSelector(".add-to-favorites")));
            logger.info(product.findElement(By.cssSelector("span")).getText()+" favorilere eklendi");
            productsIDs.add(product.getAttribute("id"));
        }
        return productsIDs;
    }


}
