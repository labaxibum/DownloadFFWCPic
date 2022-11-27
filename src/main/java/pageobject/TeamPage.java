package pageobject;

import extensions.FileExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamPage {

    WebDriver driver;
    public TeamPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By teamsLink = By.xpath("//div[contains(@class,'flag-with-info_flagCountry')]") ;

    private By teamsName(String name) {
        return By.xpath(String.format("//div[text()='%s']",name));
    }

    public void getTeamsName() throws IOException, InterruptedException {
        SquadPage squadPage = new SquadPage(driver);
        FileExtension fileExtension = new FileExtension();
        String teamName = "" ;
        WebElement firstResult = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(teamsLink));
        List<WebElement> teamsName = driver.findElements(teamsLink);
        ArrayList<String> teamNameInList = new ArrayList<String>();
        for (WebElement team: teamsName) {
            teamName = team.getText();
            teamNameInList.add(teamName);
        }

        for (String team: teamNameInList) {
            fileExtension.createFolderByTeamName(team);
            String teamRep = team.replace(" ", "-");
            System.out.println(teamRep);
            driver.get(String.format("https://www.fifa.com/fifaplus/en/tournaments/mens/worldcup/qatar2022/teams/%s/squad",teamRep.toLowerCase()));
            squadPage.getURLOfImages(team);
        }

    }

    public void clickTeam(String name)
    {
        driver.findElement(teamsName(name)).click();
    }
}
