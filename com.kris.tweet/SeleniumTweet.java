package com.kris.tweet;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class SeleniumTweet {

    WebDriver driver;

    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://twitter.com/login");
        // ENTER USERNAME
        driver.findElement(By.name("session[username_or_email]")).sendKeys("865434test");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //ENTER PASSWORD
        driver.findElement(By.className("js-password-field")).sendKeys("testing123");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.className("submit EdgeButton EdgeButton--primary EdgeButtom--medium")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String expectedUrl= driver.getCurrentUrl();
        String actualUrl = "https://twitter.com/login";
        if(actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed"); } else { System.out.println("Test failed"); }
    }
}