import POM.Home1;
import POM.SelectDoc;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Level1_UsePom {
    WebDriver driver;
    Home1 home ;
    SelectDoc doc;
    String browser = "Chrome";

    @BeforeTest
    public void setup()
    {
        if(browser == "Chrome") {
            driver = new ChromeDriver();
        } else if (browser == "firefox") {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        home = new Home1(driver);
        doc = new SelectDoc(driver);
    }
    @Test
    public void doc_validateTC() {

        home.navigateToHome();
        home.clickOnGetpaid();
        //Assertion num of doc and name
        List<WebElement> document = doc.getElements();
        Assert.assertEquals(document.size(),2);
        Assert.assertEquals(document.get(0).getText(),"Exchange a Waiver");
        Assert.assertEquals(document.get(1).getText(),"Send a Payment Document");



    }
    @Test
    public void price_validateTC()
    {
        home.navigateToHome();
        home.clickOnGetpaid();
        //Assertion num of doc and name
        List<WebElement> document = doc.getElementsPriceRange();
        Assert.assertEquals(document.size(),1);
        Assert.assertEquals(document.get(0).getText(),"Send a Warning");


    }

    @AfterTest
    public void tearDown ()
    {
        //driver.close();
    }
}
