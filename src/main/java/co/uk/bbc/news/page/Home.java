package co.uk.bbc.news.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static co.uk.bbc.news.keyword.Selenium.*;

public class Home {
    private final WebDriver driver;

    By tabNames = By.cssSelector("ul#blq-nav-main");
    By signIn = By.id("blq-idstatus-text");
    By featureSection = By.id("features");
    By signOut = By.className("idSignout");
    By tabChild = By.cssSelector("ul#blq-nav-main a");
    By tumbNailChild = By.cssSelector("div#features li.medium-image img");
    By featureChild = By.cssSelector("div#features li.medium-image a.story");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public Home navigateTo(String url) {
        driver.get(url);
        return this;
    }

    public Home clearCookies() {
        driver.manage().deleteAllCookies();
        return this;
    }

    public boolean getFeatureSection() {
        return isElementPresent(driver.findElement(featureSection));
    }

    public List getFeaturesStories() {
        List<WebElement> elements = driver.findElement(featureSection)
                .findElements(featureChild);
        return elements;
    }

    public String getStoryUrl(int i) {
        List<WebElement> stories = getFeaturesStories();
        return getTagAttribute(stories.get(i), "href");
    }

    public Home clickStory(int i) {
        List<WebElement> stories = getFeaturesStories();
        stories.get(i).click();
        return this;
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public List getThumbnail() {
        List<WebElement> elements = (driver.findElement(featureSection))
                .findElements(tumbNailChild);
        return elements;
    }

    public List getTabs() {
        List<WebElement> elements = (driver.findElement(tabNames))
                .findElements(tabChild);
        return elements;
    }

    public Home clickTab(String name) {
        List<WebElement> tabs = getTabs();
        //Loop through all the child elements
        for (WebElement element : tabs) {
            if (element.getText().equalsIgnoreCase(name)) {
                element.click();
                return this;
            }
        }
        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean getSignIn() {
        return isElementPresent(waitForElement(signIn,driver));
    }

    public Login clickSignIn() {
        waitForElement(signIn,driver).click();
        return PageFactory.initElements(driver, Login.class);
    }

    public Boolean verifySignOut() {
        return isElementPresent(waitForElement(signOut,driver));
    }
}