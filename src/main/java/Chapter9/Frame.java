package Chapter9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/frame");

        //Frame001
       WebElement frame1 = driver.findElement(By.id("firstFr"));
       driver.switchTo().frame(frame1);
       driver.findElement(By.cssSelector("input[name=\"fname\"]")).sendKeys("Arghajit");
       driver.findElement(By.cssSelector("input[name=\"lname\"]")).sendKeys("Singha");
       int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
       System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);

//       driver.switchTo().frame(0);        //To switch to inside child frame
//       driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("arghajitsingha47@gmail.com");
       driver.switchTo().defaultContent();        //To switch back to the main page
       driver.findElement(By.cssSelector("a[href=\"/video/frames\"]")).click();
       driver.close();
       driver.quit();
    }
}
