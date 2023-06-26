package test;

import base.BaseClass;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.TeamPage;

import java.io.IOException;

public class GetSrcPic extends BaseClass{
    @Test
    public void getSrcOfPic() throws IOException, InterruptedException {
        TeamPage teamPage = new TeamPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickTeamHeader();
        teamPage.getTeamsName();
    }
}
