package PageObjectModelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    WebDriver driver;

    By welcomeMessage = By.xpath("//h1[contains(@class,'title is-title')]");
    By loginToastMessage = By.id("toast-container");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String validateWelcomeMessage() {
        driver.findElement(loginToastMessage).isDisplayed();
        return driver.findElement(welcomeMessage).getText();

    }
}
