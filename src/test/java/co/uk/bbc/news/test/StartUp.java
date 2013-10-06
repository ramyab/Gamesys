package co.uk.bbc.news.test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class StartUp {
    public static WebDriver driver;
    private static Scenario scenario;

    private static String browser = "firefox";
    private static String exeEnvironment = "UAT";
    private static final String CHROME_LOCATION = "src/main/resources/chromedriver.exe";

    public static WebDriver getDriver() {
        return driver;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static String getExeEnvironment() {
        return exeEnvironment;
    }

    public static FirefoxDriver setFirefoxDriver() {
        return new FirefoxDriver();
    }

    public static ChromeDriver setChromeDriver(){
        return new ChromeDriver();
    }


    @Before("~@noWebDriver")
    public void prepare(Scenario scenario) throws MalformedURLException {

        browser = System.getProperty("browser");
        exeEnvironment = System.getProperty("environment");

        if (browser.equalsIgnoreCase("firefox")) {
            driver = setFirefoxDriver();
            this.scenario = scenario;
        }

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",CHROME_LOCATION);
            driver = new ChromeDriver();
            this.scenario = scenario;
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(Scenario scenario) {
        //Add Screen shot for failure
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        driver.close();
        driver.quit();

    }
}