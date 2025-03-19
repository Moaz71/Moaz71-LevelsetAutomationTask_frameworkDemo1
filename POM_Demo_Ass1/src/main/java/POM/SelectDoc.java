package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectDoc {

    WebDriver driver;

    String itemSelector= "//span[@class='price-amount'  and  contains(text(),'%s')]//ancestor::div[@class='panel-heading left-right-pair']/div[@class ='left']";
    String priceSelector="//span[contains(@class,\"price-amount\") and number(translate(text(),\"$\",\"\"))>30 " +
            "and  number(translate(text(),\"$\",\"\"))<60 ]" +
            "/ancestor::div[@class='panel-heading left-right-pair']/div[@class='left']";

    public SelectDoc(WebDriver driver)
    {
        this.driver=driver;
    }

    public List<WebElement> getElements() {
        return driver.findElements(new By.ByXPath(String.format(itemSelector,"Free")));
    }
    public List<WebElement> getElementsPriceRange() {
        return driver.findElements(new By.ByXPath(priceSelector));
    }
}
