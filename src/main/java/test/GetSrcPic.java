package test;

import base.BaseClass;
import extensions.FileExtension;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.SquadPage;
import pageobject.TeamDetailPage;
import pageobject.TeamPage;

import java.io.IOException;

public class GetSrcPic extends BaseClass{

    FileExtension fileExtension;

    @Test
    public void getSrcOfPic() throws IOException, InterruptedException {

        //driver.get("https://www.pixiv.net/en/artworks/337");
        TeamPage teamPage = new TeamPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickTeamHeader();
        teamPage.getTeamsName();
    }
}
