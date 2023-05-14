package Chapter8;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws Exception {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/alert");

        //Accept the Alert
        driver.findElement(By.id("accept")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Dismiss the Alert & print the alert text
        driver.findElement(By.id("confirm")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Type your name & accept
        driver.findElement(By.id("prompt")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Arghajit Singha");
        driver.switchTo().alert().accept();


        driver.close();
        driver.quit();

    }
}
