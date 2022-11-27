package test;

import base.BaseClass;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.HomePage;

public class LoginAndClickF17 extends BaseClass {


    @Test
    public void Login()
    {
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);

        //Click Login
        basePage.clickLoginBtn();
        basePage.loginIntoPage("vikoaz","Tuananh511@");

        //Click F17 thread
        homePage.scrollAndClickToThread("Chuyện trò linh tinh™");
    }
}
