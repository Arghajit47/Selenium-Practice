package Chapter11;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsInSelenium {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/windows");

        /*1. Click on the home button
        2. Goto the newly opened tab
        3. Print the title of the page
        4. Close the parent window
        5. Close the child window
        6. Click on the Multiple windows button
        7. Print all the window title
        8. Close all the windows*/


        driver.findElement(By.id("home")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> list = new ArrayList<String>(windowHandles);
        for (String winId : list) {
            System.out.println("Window Id: " + winId);
        }
        int size = list.size();
        System.out.println("No. of Windows: " + size);
        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(list.get(0));
        driver.close();
        driver.switchTo().window(list.get(1));
        driver.close();
        driver.quit();
        main1(args);
    }

    public static void main1(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/windows");

        driver.findElement(By.id("multi")).click();
        System.out.println(driver.getTitle());
        Set<String> windowHandles1 = driver.getWindowHandles();
        List<String> list1 = new ArrayList<String>(windowHandles1);
        for (String winId : list1) {
            System.out.println("Window Id: " + winId);
        }
        int size1 = list1.size();
        System.out.println("No. of Windows: " + size1);
        System.out.println(driver.getTitle());
        driver.switchTo().window(list1.get(2));
        System.out.println(driver.getTitle());
        driver.switchTo().window(list1.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(list1.get(2));
        driver.close();
        driver.switchTo().window(list1.get(1));
        driver.close();
        driver.switchTo().window(list1.get(0));
        driver.close();

        driver.quit();
    }

}
