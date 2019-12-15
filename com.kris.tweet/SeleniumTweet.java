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
        //GET URL
        driver.get("https://twitter.com/");
        // ENTER USERNAME
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/form/div[1]/input")).sendKeys("@865434test");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // ENTER PASSWORD
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/form/div[2]/input")).click();
//        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/form/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[1]/form/div[2]/input")).sendKeys("e446108");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //CLICK BUTTON
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/form/input[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //GET HOME SCREEN
//        String expectedUrl= driver.getCurrentUrl();
//        String actualUrl =
//                "https://twitter.com/home";
//        if(actualUrl.equals(expectedUrl)) {
//            System.out.println("Test passed"); } else { System.out.println("Test failed"); }
//    }
    }
}