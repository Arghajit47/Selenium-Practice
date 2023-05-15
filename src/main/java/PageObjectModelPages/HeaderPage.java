package PageObjectModelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    WebDriver driver;

    By letCodeImage = By.xpath("//img[@alt='letcode']");
    By workspaceOption = By.id("testing");
    By coursesOption = By.linkText("Courses");
    By groomingOption = By.linkText("Grooming");
    By productOption = By.xpath("//a[contains(text(),'Product')]");
    By homePageOption = By.xpath("//a[@routerlink='/']");
    By signOutButton = By.xpath("//a[contains(@class,'button is-primary')]");
    By signUpButton = By.cssSelector("a[href=\"/signup\"]");
    By logInButton = By.cssSelector("a[href=\"/signin\"]");
   public HeaderPage(WebDriver driver) {
       this.driver = driver;

    }
    public void validateHeaderPageBeforeLogin() {
        driver.findElement(letCodeImage).isDisplayed();
        driver.findElement(workspaceOption).isDisplayed();
        driver.findElement(coursesOption).isDisplayed();
        driver.findElement(groomingOption).isDisplayed();
        driver.findElement(productOption).isDisplayed();
        driver.findElement(homePageOption).isDisplayed();
        driver.findElement(signUpButton).isEnabled();
        driver.findElement(logInButton).isEnabled();
    }
    public void validateHeaderPageAfterLogin() {
        driver.findElement(letCodeImage).isDisplayed();
        driver.findElement(workspaceOption).isDisplayed();
        driver.findElement(coursesOption).isDisplayed();
        driver.findElement(groomingOption).isDisplayed();
        driver.findElement(productOption).isDisplayed();
        driver.findElement(homePageOption).isDisplayed();
        driver.findElement(signOutButton).isEnabled();

    }
}
