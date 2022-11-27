package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private By navLoginBtn = By.xpath("//div[@class='p-nav-opposite']//a[@href='/login/']");

    private By emailField = By.xpath("//input[@name='login']");
    private By passwField = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[@type='submit']");
    public void clickLoginBtn()
    {
        driver.findElement(navLoginBtn).click();
    }

    public void loginIntoPage(String email, String password)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
