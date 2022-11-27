package pageobject;

import extensions.FileExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamDetailPage {
    WebDriver driver;

    public TeamDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    private By squadLink = By.xpath("//a[text()='Squad']");

    public void clickSquadLink()
    {
        WebElement firstResult = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(squadLink));
        driver.findElement(squadLink).click();
    }
}
