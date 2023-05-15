package Chapter17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actions {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        Actions act=new Actions(driver);
        driver.switchTo().frame(0);
        //Element which needs to drag.
        WebElement From=driver.findElement(By.cssSelector("#draggable"));
        //Element on which need to drop.
        WebElement To=driver.findElement(By.cssSelector("#droppable"));

        //Dragged and dropped.
        act.dragAndDrop(From, To).build().perform();

        driver.close();
        driver.quit();
    }
}
