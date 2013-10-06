package co.uk.bbc.news.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Selenium {

    //Check Webelement exist
    public static boolean isElementPresent(WebElement webElement) {
        return webElement.isDisplayed();
    }

    //Get Element text, return string value of the element
    public static String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    //Get Element text, return string value of the element
    public static String getTagAttribute(WebElement webElement, String value) {
        return webElement.getAttribute(value);
    }

    //Return the String value of Default drop down value
    public static String getDropDownValue(WebElement webElement){
        List<WebElement> allOptions = webElement.findElements(By.tagName("option"));
        for (WebElement option : allOptions){
            if (option.isSelected()){
                return option.getText();
            }
        }
        return allOptions.get(0).getText();
    }

    //Return the css value.. for example checking text color, image size, image position
    public static String getCssValue(WebElement webElement, String cssSelector){
        return webElement.getCssValue(cssSelector);
    }

    //Get the current page url
    public static String getPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public static WebElement waitForElement(By by,WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
