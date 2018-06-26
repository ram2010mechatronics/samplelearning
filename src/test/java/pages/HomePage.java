package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessText() {
        return driver.findElement(By.xpath("//div[@class='_2cyQi_']")).getText();
    }
}
