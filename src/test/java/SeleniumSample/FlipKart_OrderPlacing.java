package SeleniumSample;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FlipKart_LoginPage;
import pages.HomePage;
import pages.TestBase;

import java.util.concurrent.TimeUnit;

public class FlipKart_OrderPlacing extends TestBase {
    public static WebDriver driver;

    @BeforeSuite
    public void testBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation related Downloads\\chromedriver_win32\\chromedriver.exe");
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
        driver.quit();
    }
}
