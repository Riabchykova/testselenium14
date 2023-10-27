package org.example.testdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverTest {

    String HUB_REMOTE = "http://put-your-hub-url-here:4444/wd/hub";

    By element = By.xpath("//*[@class='td-content']/h1");
    String expectedText = "The Selenium Browser Automation Project";
    RemoteWebDriver driver;

    @BeforeMethod
    public void chromeSetUp() throws MalformedURLException {

        driver = new RemoteWebDriver(new URL(HUB_REMOTE), new ChromeOptions());

    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.selenium.dev/documentation/");
        Thread.sleep(3000);
        String text = driver.findElement(element).getText();
        Assert.assertEquals(text, expectedText);
        driver.quit();
    }

}
