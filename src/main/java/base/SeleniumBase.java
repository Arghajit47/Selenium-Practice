package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBase {
    ChromeDriver driver;

    public void type(WebElement element, String text) {
        element.sendKeys(text);
        log("The value " + text + " is typed");
    }

    public void log(String message) {
        System.out.println(message);
    }

    public void clearAndType(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        log("The value is cleared and then " + text + " is typed");
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isReadOnly(WebElement element) {
        String result = element.getAttribute("readonly");
        if(result.equals("true")) {
            return  true;
        } else {
            return  false;
        }
    }

    public void click(WebElement element) {
        element.click();
        log("The Element is clicked");
    }

    public void clickAndHold(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element);
        log("The element is clicked and hold");
    }

    public String getElementColor(WebElement elemnet) {
        String cssValue = elemnet.getCssValue("background-color");
        log("Background Color: " + cssValue);
        return cssValue;
    }

    public void selectText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
        WebElement selectOption = select.getFirstSelectedOption();
        if(selectOption.getText().equals(visibleText)) {
            log("Is Selected");
        } else {
            log("Cannot be Selected");
        }
    }

    public void selectValue(WebElement element, String visibleValue) {
        Select select = new Select(element);
        select.selectByValue(visibleValue);

    }

    public void selectIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    public void acceptAlert() {
        log("Alert Text is: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    public void dismissAlert() {
        log("Alert Text is: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }
    public void typeInAlert(String text) {
        log("Alert Text is: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys(text);
    }
}
