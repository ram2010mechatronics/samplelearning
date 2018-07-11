package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessText() {
        Point point = driver.findElement(By.xpath("//div[@class='_2cyQi_']")).getLocation();
        int xcord = point.getX();
        System.out.println("Element's Position from left side Is "+xcord +" pixels.");
        int ycord = point.getY();
        System.out.println("Element's Position from top side Is "+ycord +" pixels.");
        return driver.findElement(By.xpath("//div[@class='_2cyQi_']")).getText();
    }
}
