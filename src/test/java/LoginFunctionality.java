import PageObjectModelPages.HeaderPage;
import PageObjectModelPages.HomePage;
import PageObjectModelPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginFunctionality {
    WebDriver driver = new ChromeDriver();

    HomePage objHomePage;
    HeaderPage objHeaderPage;
    LoginPage objLoginPage;
    Properties prop = new Properties();
    FileInputStream fis;

    {
        try {
            fis = new FileInputStream("/home/arghas/IdeaProjects/Selenium-Practice/src/test/java/Data.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @BeforeTest
    public void setup() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        prop.load(fis);
        driver.get(prop.getProperty("Url"));
    }
    @Test
    public void loginFunctionality() throws Exception {
        objHomePage = new HomePage(driver);
        objHeaderPage = new HeaderPage(driver);
        objLoginPage = new LoginPage(driver);
        prop.load(fis);

        objHeaderPage.validateHeaderPageBeforeLogin();
        objLoginPage.loginToWebsite(prop.getProperty("EmailId"), prop.getProperty("Password") );
        objHomePage.validateWelcomeMessage();
        objHeaderPage.validateHeaderPageAfterLogin();
    }
    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
