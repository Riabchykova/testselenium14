package org.example.testdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocalDriverTest {
    ChromeDriver chromeDriver;
    By element = By.xpath("//*[@class='td-content']/h1");
    String expectedText = "The Selenium Browser Automation Project";

    @BeforeMethod
    public void chromeSetUp() {

        chromeDriver = new ChromeDriver(new ChromeOptions());
    }

    @Test
    public void test() throws InterruptedException {

        chromeDriver.get("https://www.selenium.dev/documentation/");
        Thread.sleep(3000);
        String text = chromeDriver.findElement(element).getText();
        Assert.assertEquals(text, expectedText);
        chromeDriver.quit();
    }
}
