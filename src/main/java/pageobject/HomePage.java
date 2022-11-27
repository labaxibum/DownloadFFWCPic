package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    ////nav[contains(@class,'global-menu-top-nav_mainLink')]//a[text()='TEAMS']
    private By teamLink = By.xpath("//a[text()='TEAMS']");
    private By threadPage(String threadName){
        return By.xpath(String.format("//a[text()='%s']",threadName));
    }

    private By okButton = By.xpath("//button[contains(text(),'I')]");
    public void scrollAndClickToThread(String threadName)
    {
        driver.findElement(threadPage(threadName));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView (true);", threadPage(threadName));
        driver.findElement(threadPage(threadName)).click();
    }

    public void clickTeamHeader()
    {
        WebElement firstResult = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(okButton));
        driver.findElement(okButton).click();
        WebElement firstResult1 = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(teamLink));
        driver.findElement(teamLink).click();
    }
}
