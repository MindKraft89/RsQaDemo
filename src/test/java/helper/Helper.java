package helper;

import logger.Log;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Helper {

    public static void assertElementPresent(WebElement element) {
        Log.info("assertElementPresent" + element);
        Assert.assertTrue(element.isDisplayed());
    }

    public static void assertElementText(WebElement element, String txt) {
        Log.info("assertElementText" + element);
        Assert.assertTrue(element.getText().equalsIgnoreCase(txt));
    }

    public static void assertElementValue(WebElement element, String value) {
        Log.info("assertElementValue" + element);
        Assert.assertTrue(element.getAttribute("value").equalsIgnoreCase(value));
    }

    public static void click(WebElement element) {
        Log.info("click" + element);
        element.click();
    }

    public static void type(WebElement element, String txt) {
        Log.info("type" + " '" + txt + "' " + element);
        element.click();
        element.sendKeys(txt);
    }
}
