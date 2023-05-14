package Chapter5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inputs {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/edit");

        //TC001
        driver.findElement(By.id("fullName")).sendKeys("Arghajit Singha");
        //TC002
        System.out.println(driver.findElement(By.id("join")).getAttribute("value"));
        driver.findElement(By.id("join")).sendKeys(" now! I don't know how much time I can hold all these, but life is like this", Keys.TAB);
        System.out.println(driver.findElement(By.id("join")).getAttribute("value"));
        //TC003
        String getMeText = driver.switchTo().activeElement().getAttribute("value");         //As we know that after pressing TAB, we are in the next element already
        System.out.println(getMeText);
        System.out.println(driver.findElement(By.id("getMe")).getAttribute("value"));       //Or otherwise we can do this
        //TC004
        System.out.println(driver.findElement(By.id("clearMe")).getAttribute("value"));
        driver.findElement(By.id("clearMe")).clear();
        //TC005
        System.out.println(driver.findElement(By.id("noEdit")).isEnabled());
        //TC006
        System.out.println(driver.findElement(By.id("dontwrite")).getAttribute("value"));
        System.out.println(driver.findElement(By.id("dontwrite")).isEnabled());
        System.out.println(driver.findElement(By.id("dontwrite")).getAttribute("readonly"));

        driver.quit();
    }
}
