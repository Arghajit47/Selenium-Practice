package Chapter6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Buttons {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/buttons");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        //TC001
        wait.until(ExpectedConditions.elementToBeClickable(By.id("home")));
        driver.findElement(By.id("home")).click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        //TC002
        System.out.println("X coordinate for the button is: " + driver.findElement(By.id("position")).getLocation().getX());
        System.out.println("Y coordinate for the button  is: " + driver.findElement(By.id("position")).getLocation().getY());

        System.out.println("(X, Y) : " + driver.findElement(By.id("position")).getLocation());

        //TC003
        System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));

        //TC004
        System.out.println("Tall: " + driver.findElement(By.id("property")).getRect().height);
        System.out.println("Fat: " + driver.findElement(By.id("property")).getRect().width);

        //TC005
        System.out.println(driver.findElement(By.id("isDisabled")).getAttribute("disabled"));

        //TC006
        WebElement button = driver.findElement(By.xpath("//h2[contains(text(),'Button Hold!')]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(button);

        driver.quit();
    }
}
