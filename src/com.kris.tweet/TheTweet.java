package com.kris.tweet;
import org.openqa.selenium.WebDriver;
import twitter4j.*;
import twitter4j.examples.tweets.RetweetStatus;
import twitter4j.StatusUpdate;


public class TheTweet{
 //  declaring twitter factory and status id;
    public static long id;
    private static Twitter twitter = TwitterFactory.getSingleton();
    //Selenium support
    private WebDriver driver;
    private SeleniumTweet sDriver;


    public static void main(String[] args) {
        id = FirstTweet();
        Retweet();
        Reply();
        //Selenium support
        SeleniumTweet sDrive = new SeleniumTweet(id);
        sDrive.startBrowser();
    }
    public static long FirstTweet() {
        //Twitter twitter = TwitterFactory.getSingleton();
        //makes an instance via connecting and authorization
        String tweet = "Hello, just a tweeting testing again and again and now again too and salt " + Math.random();
        Status status = null;
        try {
          status = twitter.updateStatus(tweet);
            //makes the first Tweet
            System.out.printf("Successfully updated status to: " + status.getText() +"id:" + status.getId());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return status.getId();
//        return id = status.getId();
    }
    public static void Retweet() {
      // TwitterFactory factory = new TwitterFactory();
       // Twitter twitter = TwitterFactory.getSingleton();
        try {
            Status status = twitter.retweetStatus(id);
          //  makes Retweet based on id
          System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() +"id:"+ status.getId());
            // prints the Usernname, FistTweet and Retweet+id
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    public static void Reply(){
        //TwitterFactory factory = new TwitterFactory();
       // Twitter twitter = TwitterFactory.getSingleton();
        String replyMessage="Hi, this is just a test message.";

        Long inReplyToStatusId = id;
        try {
            StatusUpdate statusUpdate = new StatusUpdate(replyMessage);
            statusUpdate.setInReplyToStatusId(inReplyToStatusId);
            Status status = twitter.updateStatus(statusUpdate);
            //  makes Reply of the given tweet id
            System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() + status.getId());
            // prints the Reply
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}


