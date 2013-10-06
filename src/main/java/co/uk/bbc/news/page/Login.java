package co.uk.bbc.news.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    By userId = By.id("bbcid_unique");
    By password = By.id("bbcid_password");
    By signIn = By.id("bbcid_submit_button");

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public Login enterUserId(String user){
        driver.findElement(userId).sendKeys(user);
        return this;
    }

    public Login enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
        return this;
    }

    public Home clickSignIn(){
        driver.findElement(signIn).click();
        return PageFactory.initElements(driver, Home.class);
    }

    public Home loginValidCredential(String user, String pwd){
        return enterUserId(user)
                .enterPassword(pwd)
                .clickSignIn();
    }
}