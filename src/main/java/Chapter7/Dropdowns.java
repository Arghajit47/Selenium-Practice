package Chapter7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdowns {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/dropdowns");

        //Select the apple using visible text
        WebElement fruitsElement = driver.findElement(By.id("fruits"));
        Select fruits = new Select(fruitsElement);
        fruits.selectByValue("0");
        System.out.println(driver.findElement(By.cssSelector("div > div > p")).getText());

        //Select Batman, Aquaman, Superman and Batwomen
        WebElement superHeros = driver.findElement(By.id("superheros"));
        Select supers = new Select(superHeros);
        supers.selectByIndex(4);
        supers.selectByValue("aq");
        supers.selectByVisibleText("Batman");
        supers.selectByValue("sm");
        List<WebElement> allSelectedOptions = supers.getAllSelectedOptions();
        for (WebElement superHero : allSelectedOptions) {
            System.out.println(superHero.getText());
        }
        //Select the last programming language and print all the options
        WebElement languages = driver.findElement(By.id("lang"));
        Select language = new Select(languages);
        language.selectByValue("sharp");
        List<WebElement> allOptions = language.getOptions();
        for(WebElement lang : allOptions) {
            System.out.println(lang.getText());
        }

        //Select India using value & print the selected value
        WebElement countries = driver.findElement(By.id("country"));
        Select country = new Select(countries);
        country.selectByValue("India");
        WebElement selectedCountry = country.getFirstSelectedOption();
        System.out.println(selectedCountry.getText());


        driver.close();
        driver.quit();
    }
}
