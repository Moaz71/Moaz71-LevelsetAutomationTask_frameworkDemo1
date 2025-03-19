package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import Actions.ElementActions;


import java.time.Duration;

public class Home1 {

    String homePageUrl= "https://www.levelset.com/";
    WebDriver driver;
    ElementActions act;

    /***********************************Locator************************************************/
    By getPaid = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']") ;
    By homeExpectedElement =By.xpath("//*[@id=\"header\"]/div/div/div[1]/a");
    By getPaidExpectedElement =By.xpath("//div[@class=\"step-title\"]");

    public Home1(WebDriver driver){
        this.driver=driver;
        act = new ElementActions(driver);
    }

    // version two after implement Actions
    public void navigateToHome() {

        act.navigate(homePageUrl,homeExpectedElement);
    }

    public void clickOnGetpaid() {

        act.click(getPaid,getPaidExpectedElement);

    }
}

