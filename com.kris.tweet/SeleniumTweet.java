package com.kris.tweet;

import com.kris.tweet.TheTweet;


import okhttp3.HttpUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTweet {

    WebDriver driver;
    public long id;

    public SeleniumTweet(long id) {
        this.id = id;
    }

    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //GET URL
        driver.get("https://twitter.com/");

        // ENTER USERNAME
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/form/div[1]/input")).sendKeys("@865434test");

        // ENTER PASSWORD
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/form/div[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[1]/form/div[2]/input")).sendKeys("e446108");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //  CLICK BUTTON
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/form/input[1]")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // Go to delete last message
        driver.get("https://twitter.com/865434test/status/" + id + "/");
        driver.findElement(By.cssSelector("#react-root > div > div > div > main > div > div > div > div > div > div:nth-child(2) > div > section > div > div > div > div:nth-child(3) > div > article > div > div:nth-child(2) > div.css-1dbjc4n.r-1iusvr4.r-16y2uox.r-1777fci.r-5f2r5o.r-1mi0q7o > div:nth-child(1) > div.css-1dbjc4n.r-18u37iz.r-1h0z5md.r-1joea0r > div > div")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div[3]/div/div/div/div[1]")).click();
//        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div/div/div[2]/div/section/div/div/div/div[3]/div/article/div/div[2]/div[2]/div[1]/div[2]/div")).click();

        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div[3]/div[2]")).click();

        driver.quit();
    }
}