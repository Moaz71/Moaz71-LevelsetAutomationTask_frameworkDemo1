package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    WebDriver driver;
     public ElementActions(WebDriver driver)
     {
         this.driver=driver;
     }
/**************************** navigate method ***********************************************/
     public void navigate(String url ,By expectedElement)
     {
        driver.get(url);
        try {
            if(validateOnElement(expectedElement,"visibility"));

        } catch (Exception e) {
            System.out.println("Failed to navigate to page ");

        }


     }
    /**************************** validateOnElement method ***********************************************/
    public boolean validateOnElement(By element, String s){
        ExpectedCondition<WebElement> condition = null;
        switch (s){
            case "presence" : condition= ExpectedConditions.presenceOfElementLocated(element);
                break;
            case "visibility" : condition= ExpectedConditions.visibilityOfElementLocated(element);
                break;
            case "clickable" : condition= ExpectedConditions.elementToBeClickable(element);
                break;
        }


        if (condition != null) {
            // if fail this will pass exception
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(condition);
        }
        return true;
    }

    /*********************************** click method **********************************/
    public boolean click(By element ,By expectedElement){

        Actions actions = new Actions(driver);

        try {
            if(validateOnElement(element,"clickable")){
                driver.findElement(element).click();
                System.out.println("try click ");

            }
            //***************check the element presence
            if (validateOnElement(expectedElement,"presence")) {
                return true;
            }
        }catch (Exception e) {
            try {
                //Hover
                actions.moveToElement(driver.findElement(element)).perform();
                driver.findElement(element).click();
                System.out.println("try hover ");

                if (validateOnElement(expectedElement,"presence")) {
                    return true;
                }
            } catch (Exception ex) {
                try {
                    //Enter
                    driver.findElement(element).sendKeys(Keys.ENTER);
                    System.out.println("try Enter ");

                    if (validateOnElement(expectedElement,"presence")) {
                        return true;
                    }

                } catch (Exception exc) {
                    try {
                        //doubleClick
                        actions.doubleClick(driver.findElement(element)).perform();
                        System.out.println("try doubleClick ");

                        if (validateOnElement(expectedElement,"presence")) {
                            return true;
                        }
                    } catch (Exception e1) {
                        System.out.println("Failed to interact with element ");

                    }
                }

            }


        }

        return false;
    }
}
