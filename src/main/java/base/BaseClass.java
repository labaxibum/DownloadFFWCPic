package base;

import extensions.FileExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseClass {
    FileExtension fileExtension = new FileExtension();
    String platform = "local";
    public WebDriver driver;
    public WebDriver createRemoteDriver(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platform","windows");
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
        return driver;
    }

    public WebDriver createBrowserstackDriver(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName",browser);
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion","10");
        browserstackOptions.put("seleniumVersion","3.141.59");
        browserstackOptions.put("sessionName","BS Sample");
        capabilities.setCapability("bstack:options",browserstackOptions);
        String USERNAME = "anhle_NOKGWr";
        String AUTOMATE_KEY = "sajBQtzsQcjiRuFzzTyk";
        WebDriver driver = new RemoteWebDriver(new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub"),capabilities);
        return driver;
    }
    public WebDriver createLocalDriver(String browser){

        String currentWorkingDir = fileExtension.getCurrentWorkingDir();
        String chromeDriverPath =  currentWorkingDir + "\\driver\\chromedriver.exe";
        String firefoxDriverPath = currentWorkingDir + "\\driver\\geckodriver.exe";
        WebDriver driver = null;
        if (browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",chromeDriverPath);
            System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            driver = new FirefoxDriver();
        }
        return driver;
    }
    @Parameters({"browser"})
    @BeforeClass
    public void setBrowser(@Optional("chrome") String browser) throws MalformedURLException {
        switch (platform) {
            case "bs":
                driver = createBrowserstackDriver(browser);
                break;
            case "local":
                driver = createLocalDriver(browser);
                break;
            case "remote":
                driver = createRemoteDriver(browser);
                break;
        }

        driver.manage().window().maximize();
        driver.get("https://www.fifa.com/fifaplus/en/home");
    }

    @AfterClass
    public void tearDown(){driver.quit();}

}