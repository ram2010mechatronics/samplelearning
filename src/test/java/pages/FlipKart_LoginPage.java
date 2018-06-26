package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKart_LoginPage {
    private WebDriver driver;

    public FlipKart_LoginPage(WebDriver driver) {
        this.driver = driver;
        if(!driver.getTitle().equals("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More")) {
            driver.get("https://www.flipkart.com/");
        }
    }

    public HomePage correctLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Enter Email/Mobile number']")));
        driver.findElement(By.xpath("//form//following::input[@type='text']")).sendKeys(username);
        driver.findElement(By.xpath("//form//following::input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']//following-sibling::span[text()='Login']")).click();
        return new HomePage(driver);
    }
}


