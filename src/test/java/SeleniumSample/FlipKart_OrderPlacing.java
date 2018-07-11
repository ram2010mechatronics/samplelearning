package SeleniumSample;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FlipKart_LoginPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class FlipKart_OrderPlacing {
    public static WebDriver driver;

    @BeforeSuite
    public void testBrowser() {
        System.setProperty("webdriver.chrome.driver", "R:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description="Performs an unsuccessful login and checks the resulting error message")
    public void testLogin() {
        FlipKart_LoginPage lp = new FlipKart_LoginPage(driver);
        HomePage hp = lp.correctLogin("ram2010mech@gmail.com", "Ramachandran02");
        Assert.assertEquals(hp.getSuccessText(), "Ramachandran");
    }


    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }
}
