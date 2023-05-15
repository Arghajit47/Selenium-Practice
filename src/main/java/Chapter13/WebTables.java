package Chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WebTables {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.get("https://letcode.in/table");

        driver.findElements(By.cssSelector("#shopping > thead > tr > th")).get(0).getText();
        driver.findElements(By.cssSelector("#shopping > thead > tr > th")).get(1).getText();

        int totalCost = 0;
        for (int i = 0; i < 8; i++) {
            if (i%2 == 0) {
                String shoppingElements = driver.findElements(By.cssSelector("#shopping > tbody > tr > td")).get(i).getText();


            } else {
                int shoppingPrice = Integer.parseInt(driver.findElements(By.cssSelector("#shopping > tbody > tr > td")).get(i).getText());

                totalCost = totalCost + shoppingPrice;
                if (i == 7) {
                    int total = Integer.parseInt(driver.findElements(By.cssSelector("#shopping > tfoot > td")).get(1).getText());
                    if(total == totalCost) {
                        System.out.println("The Total Cost of shopping is matched with the UI, which is " + totalCost);
                    } else {
                        System.out.println("Total cost of shopping is not matching with calculation");
                    }

                } else {
                    continue;
                }
            }
        }
        driver.findElement(By.id("second")).click();
        if (driver.findElement(By.id("second")).isSelected() == true) {
            System.out.println("Raj has been marked present");
        } else {
            System.out.println("Automation Failed!");
        }




        driver.quit();
    }
}
