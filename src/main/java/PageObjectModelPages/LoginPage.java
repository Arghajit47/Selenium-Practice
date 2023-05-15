package PageObjectModelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By logInButton = By.cssSelector("a[href=\"/signin\"]");
    By inputEmail = By.cssSelector("input[name=\"email\"]");
    By inputPassword = By.cssSelector("input[name=\"password\"]");
    By clickOnLoginConfirmButton = By.xpath("//button[contains(text(),'LOGIN')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void loginToWebsite(String email, String password) {
        driver.findElement(logInButton).click();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(clickOnLoginConfirmButton).click();
    }
}
