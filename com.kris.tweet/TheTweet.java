package com.kris.tweet;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.examples.tweets.RetweetStatus;

import java.lang.reflect.Array;


public class TheTweet{
    private static Object Status;
    private static long id;


    public static void main(String[] args) throws TwitterException {
        FirstTweet();
        Retweet();
      // TODO Auto-generated catch block
    }
    public static long FirstTweet() {
        Twitter twitter = TwitterFactory.getSingleton();
        //makes an instance via connecting and authorization
        String tweet = "Hello, just a tweeting testing again and again and now again too2" +1;
        Status status = null;
//        String[] statusReturn = null;
        try {
          status = twitter.updateStatus(tweet);
            //makes the first Tweet
            System.out.printf("Successfully updated status to: " + status.getText() + status.getId());
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
          //  makes Retweet of the given id
          System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() + status.getId());
            // peint the FistTweet and Retweet
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
}


