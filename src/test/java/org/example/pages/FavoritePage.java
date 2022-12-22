package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FavoritePage {
    Logger logger= LogManager.getLogger(FavoritePage.class);
    Method method;
    public FavoritePage(){
        method=new Method();
    }
    public void checkFavorite(List<String> addedFavoriteProductList){
        method.refresh();
        List<WebElement> favProds=method.findElementList(By.className("product-list"),By.className("product-cr"));
        List<String> onFavoritePageList=new ArrayList<>();
        for(WebElement product:favProds){
            onFavoritePageList.add(product.getAttribute("id"));
        }
        Collections.sort(addedFavoriteProductList);
        Collections.sort(onFavoritePageList);
        Assertions.assertEquals(addedFavoriteProductList, onFavoritePageList, "urunler favorilere eklenemedi");
        logger.info("Urunler 'Listelerim>Favorilerim' sayfasina eklendi ");
    }
    public void removeProdFromFav(String productId){

        method.scrollWithJS(method.findElement(By.xpath("//div[@id='"+productId+"']")));
        method.clickJS(method.findElement(By.xpath("//div[@id='"+productId+"']")).findElement(By.xpath("//a[@data-title='Favorilerimden Sil']")));
        Assertions.assertTrue(method.isElementVisible(By.cssSelector(".success")),productId+" id liurun favorilerden silinemedi");
        logger.info(productId+" id li urun favorilerden silindi");
    }
}
