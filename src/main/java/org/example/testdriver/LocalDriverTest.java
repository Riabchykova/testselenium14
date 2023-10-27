package org.example.testdriver;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class LocalDriverTest {
    ChromeDriver chromeDriver;
    By element = By.xpath("//*[@class='td-content']/h1");
    String expectedText = "The Selenium Browser Automation Project";

    @BeforeMethod
    public void chromeSetUp() {

        chromeDriver = new ChromeDriver(new ChromeOptions());
        WebDriverRunner.setWebDriver(chromeDriver);
    }

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = webdriver().object();
        webdriver().object().get("https://www.selenium.dev/documentation/");
        Thread.sleep(3000);
        String text = $(element).getText();
        Assert.assertEquals(text, expectedText);
        chromeDriver.quit();
    }
}
