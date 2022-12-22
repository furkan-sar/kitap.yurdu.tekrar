package org.example.methods;

import org.example.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Method {
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsDriver;
    WebDriver driver;
    public Method(){
        driver=BaseTest.driver;
        wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsDriver=(JavascriptExecutor)BaseTest.driver;

    }
    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public List<WebElement> findElementList(By parentLocator,By childLocator){
        return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parentLocator,childLocator));
    }
    public void clickJS(WebElement element){
        jsDriver.executeScript("arguments[0].click();", element);
    }

    public void clickJS(By by){
        jsDriver.executeScript("arguments[0].click();",findElement(by));
    }
    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
    }
    public boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));

            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isElementClickable(By by){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isElementExist(By by){
        try{
            ExpectedConditions.presenceOfElementLocated(by);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public String getValue(By by){
        return findElement(by).getAttribute("value");
    }
    public void scrollWithJS(WebElement webElement){
        jsDriver.executeScript("arguments[0].scrollIntoView();",webElement);
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    public void scrollWithAction(By by){
        Actions actions=new Actions(BaseTest.driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public void selectByText(By by,String text){
        getSelect(by).selectByVisibleText(text);
    }
    public void selectByValue(By by,String value){
        getSelect(by).selectByValue(value);
    }
    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public List<WebElement> getList(By paretLocator,By childLocator){
        return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(paretLocator,childLocator));
    }
    public int giveRandomNumber(int endNumber){
        return new Random().nextInt(endNumber);
    }

    public void clearInput(By by){
        findElement(by).clear();
    }
    public void refresh(){
        driver.navigate().refresh();
    }
}
