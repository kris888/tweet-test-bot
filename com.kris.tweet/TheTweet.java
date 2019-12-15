package com.kris.tweet;

import org.openqa.selenium.WebDriver;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.examples.tweets.RetweetStatus;
import twitter4j.StatusUpdate;


public class TheTweet{
    private static Object Status;
    public static long id;
    //Selenium support
    WebDriver driver;
    private SeleniumTweet sDriver;

    public static void main(String[] args) throws TwitterException {
        id = FirstTweet();
        Retweet();
        Reply();
        //Selenium support
        SeleniumTweet sDrive = new SeleniumTweet(id);
        sDrive.startBrowser();
    }
    public static long FirstTweet() {
        Twitter twitter = TwitterFactory.getSingleton();
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
    public static Long Retweet() throws TwitterException{
        TwitterFactory factory = new TwitterFactory();
        Twitter twitter = TwitterFactory.getSingleton();
        try {
            Status status = twitter.retweetStatus(id);
          //  makes Retweet based on id
          System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() +"id:"+ status.getId());
            // prints the Usernname, FistTweet and Retweet+id
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Long Reply() throws TwitterException {
        TwitterFactory factory = new TwitterFactory();
        Twitter twitter = TwitterFactory.getSingleton();
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
        return null;
    }
}


