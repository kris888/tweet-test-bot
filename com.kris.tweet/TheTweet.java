package com.kris.tweet;

import org.openqa.selenium.WebDriver;

import twitter4j.*;
import twitter4j.examples.tweets.RetweetStatus;


public class TheTweet{
    private static Object Status;
    private static long id;
    //Selenium support
    WebDriver driver;
    private SeleniumTweet sDriver;

    public static void main(String[] args) throws TwitterException {
        FirstTweet();
        Retweet();
        Replay();
        //Selenium support
        SeleniumTweet sDrive = new SeleniumTweet();
        sDrive.startBrowser();

    }
    public static long FirstTweet() {
        Twitter twitter = TwitterFactory.getSingleton();
        //makes an instance via connecting and authorization
        String tweet = "Hello, just a tweeting testing again and again and now again too45";
        Status status = null;
        try {
          status = twitter.updateStatus(tweet);
            //makes the first Tweet
            System.out.printf("Successfully updated status to: " + status.getText() +"id:" + status.getId());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return id=status.getId();
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

    public static Long Replay() throws TwitterException {
        TwitterFactory factory = new TwitterFactory();
        Twitter twitter = TwitterFactory.getSingleton();
        String replyMessage="Hi, this is just a test message.";
        Long inReplyToStatusId = id;
        try {
            StatusUpdate statusUpdate = new StatusUpdate(replyMessage);
            statusUpdate.setInReplyToStatusId(inReplyToStatusId);
            Status status = twitter.updateStatus(statusUpdate);
            //  makes Replay of the given id
            System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() + status.getId());
            // prints the Replay
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
}


