package Chapter1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in");
        String email = "koushik350@gmail.com";
        String password = "Pass123$";
        driver.findElement(By.cssSelector("div > a[href=\"/signin\"]")).click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        driver.close();     //Kills the active Tab, but not the driver
        driver.quit();      //Kills driver and saves the memory

    }
}
