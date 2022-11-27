package pageobject;

import extensions.StringExtensions;
import extensions.FileExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class SquadPage {

    WebDriver driver;

    public SquadPage(WebDriver driver) {
        this.driver = driver;
    }

    private By imgInThread = By.xpath("//div[@class='message-cell message-cell--main']//div[@class='bbImageWrapper  js-lbImage']/img");

    private By imgInPixiv = By.xpath("//div[@role='presentation']//img");
    private By imgInFFWc = By.xpath("//div[contains(@class,'player-badge-card_playerImage__3')]");
    public String getURLOfImages(String teamName) throws IOException, InterruptedException {
        FileExtension fileExtension = new FileExtension();
        StringExtensions stringExtensions = new StringExtensions();
        String src = "";
        WebElement firstResult = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(imgInFFWc));
        List<WebElement> imgList = driver.findElements(imgInFFWc);
       /** for (WebElement img : imgList) {
            src = img.getAttribute("src");
            String srcAfterFilter = stringExtensions.filterWWWUrl(src);
            System.out.println(srcAfterFilter);
            if (srcAfterFilter != "")
            {
                fileExtension.downloadFileByURL(srcAfterFilter);
            }
            else {
                System.out.println("Different file format");
            };
        } **/

       for (WebElement img : imgList)
       {
           src = img.getAttribute("style");
           String srcAfterFilter = stringExtensions.splitURLString(src);
           System.out.println(srcAfterFilter);
           String imageID = stringExtensions.splitImageURL(srcAfterFilter);
           System.out.println(imageID);
           fileExtension.downloadFileByURL(srcAfterFilter,teamName, imageID);
       }
        return src;
    }
}
