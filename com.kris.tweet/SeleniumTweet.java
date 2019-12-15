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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Go to delete last message
        driver.findElement(By.partialLinkText("https://twitter.com/865434test/status/" + id)).click();
        //  id=caret
//    ele.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);;
//     //   driver.findElement(By.("div.r-daml9f > span:nth-child(1)")).click();
//        driver.findElement(By.cssSelector("#react-root > div > div > div.r-1d2f490.r-u8s1d.r-zchlnj.r-ipm5af.r-184en5c > div > div > div:nth-child(2) > div.css-1dbjc4n.r-14lw9ot.r-1f0042m.r-1upvrn0.r-1ekmkwe.r-1udh08x.r-u8s1d > div > div > div > div:nth-child(1)")).click();
    }
    //driver.quit();
}
//}
//#react-root > div > div > div > main > div > div > div > div.css-1dbjc4n.r-14lw9ot.r-1tlfku8.r-1ljd8xs.r-13l2t4g.r-1phboty.r-1jgb5lz.r-11wrixw.r-61z16t.r-1ye8kvj.r-13qz1uu.r-184en5c > div > div.css-1dbjc4n.r-1jgb5lz.r-1ye8kvj.r-13qz1uu > div > div > section > div > div > div > div:nth-child(1) > div > article > div > div:nth-child(2) > div.css-1dbjc4n.r-1iusvr4.r-16y2uox.r-1777fci.r-5f2r5o.r-1mi0q7o > div.css-1dbjc4n.r-18u37iz.r-1wtj0ep.r-zl2h9q > div.css-1dbjc4n.r-18u37iz.r-1h0z5md.r-1joea0r > div > div > div > div
//
////*[@id="react-root"]/div/div/div/main/div/div/div/div[1]/div/div[4]/div/div/section/div/div/div/div[1]/div/article/div/div[2]/div[2]/div[1]/div[2]/div/div/div/div