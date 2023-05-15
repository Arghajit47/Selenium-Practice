package Chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiValidation {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/radio");

        //Select any one
        driver.findElement(By.id("yes")).click();
        System.out.println(driver.findElement(By.id("yes")).isSelected());

        //Confirm you can select only one radio button
        driver.findElement(By.id("two")).click();
        System.out.println(driver.findElement(By.id("two")).getAttribute("type").equals("radio"));

        //Find the bug
        driver.findElement(By.id("bug")).click();
        driver.findElement(By.id("nobug")).click();
        driver.findElement(By.id("bug")).isSelected();
        driver.findElement(By.id("nobug")).isSelected();
        System.out.println(driver.findElement(By.id("bug")).getAttribute("type").equals("radio"));
        System.out.println(driver.findElement(By.id("nobug")).getAttribute("type").equals("radio"));

        //Find which one is selected
        if (driver.findElement(By.id("foo")).isSelected() == true) {
            System.out.println("'Foo' option is selected here");
        } else {
            System.out.println("'Bar' option is selected here");
        }

        //Confirm last field is disabled
        driver.findElement(By.id("maybe")).getAttribute("disabled");

        //Find if the checkbox is selected?
        System.out.println(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).getAttribute("checked"));


        //Accept the T&C
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        System.out.println(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected());

        driver.close();
        driver.quit();
    }

}

