package com.kris.tweet;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.examples.tweets.RetweetStatus;

import java.lang.reflect.Array;


public class TheTweet{
    private static Object Status;


    public static void main(String[] args) throws TwitterException {
        FirstTweet();
        Retweet();
//        noArgsFuction(args);

        if (args.length < 1) {
            System.out.println("Usage: java twitter4j.examples.tweets.RetweetStatus [status id]");
            System.exit(-1);
        }
        System.out.println("Retweeting the status id - [" + args[0] + "].");
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.retweetStatus(Long.parseLong(args[0]));
            System.out.println("Successfully retweeted status [" + args[0] + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to retweet: " + te.getMessage());
            System.exit(-1);
        }
    }

    public static long FirstTweet() {
        Twitter twitter = TwitterFactory.getSingleton();
        //makes an instance via connecting and authorization
        String tweet = "Hello, just a tweeting testing again and again and now"+1;
        Status status = null;
//        String[] statusReturn = null;
        try {
             status = twitter.updateStatus(tweet);
            //makes the first Tweet
            System.out.printf("Successfully updated status to: " + status.getText() + status.getId());
//            statusReturn.equals(status.getId());
//            return statusReturn;
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return status.getId();
    }
//    public final class RetweetStatus {
//        /**
//         * Usage: java twitter4j.examples.tweets.RetweetStatus [status id]
//         *
//         * @param args message
//         */
//        public  void main(String[] args) {
//            if (args.length < 1) {
//                System.out.println("Usage: java twitter4j.examples.tweets.RetweetStatus [status id]");
//                System.exit(-1);
//            }
//            System.out.println("Retweeting the status id - [" + args[0] + "].");
//            try {
//                Twitter twitter = new TwitterFactory().getInstance();
//                twitter.retweetStatus(Long.parseLong(args[0]));
//                System.out.println("Successfully retweeted status [" + args[0] + "].");
//                System.exit(0);
//            } catch (TwitterException te) {
//                te.printStackTrace();
//                System.out.println("Failed to retweet: " + te.getMessage());
//                System.exit(-1);
//            }
//        }
//    }
//    public class GetHomeTimeline {
//        /**
//         * Usage: java twitter4j.examples.timeline.GetHomeTimeline
//         *
//         * @param args String[]
//         */
//        public void main(String[] args) {
//            try {
//                // gets Twitter instance with default credentials
//                Twitter twitter = new TwitterFactory().getInstance();
//                User user = twitter.verifyCredentials();
//                List<Status> statuses = twitter.getHomeTimeline();
//                System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
//                for (Status status : statuses) {
//                    System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
//                }
//            } catch (TwitterException te) {
//                te.printStackTrace();
//                System.out.println("Failed to get timeline: " + te.getMessage());
//                System.exit(-1);
//            }
//        }
//    }
    public static Long Retweet() throws TwitterException{
        TwitterFactory factory = new TwitterFactory();
        Twitter twitter = TwitterFactory.getSingleton();
//        String consumerKey = "5u8PTPH4wfem97GzZu2IpLsr2";
//        String consumerSecret = "u8EOJqds1sGgrE4YkLi3h6B5Vux4EHygjWCWKIOESsi7QNhI1R";
//        String twitterToken = "1204131369015750659-G0MAC8Ka2OipYIOBSHxzMFjXyllBzO";
//        String twitterSecret = "VvTZl9VHNjbEwWveDQkqjgzO2iHN15FjJQHsYBHMgknvP";
        //  System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() + status.getId());
        Long tweetId = twitter.getId();
        try {
//            twitter.setOAuthConsumer(consumerKey, consumerSecret);
//            AccessToken accessToken = new AccessToken(twitterToken, twitterSecret);
           // twitter.setOAuthAccessToken(accessToken);
          //  Long tweetId = twitter.getId();
//            TwitterFactory factory = new TwitterFactory();
//            Twitter twitter = factory.getInstance();
//            String consumerKey ="5u8PTPH4wfem97GzZu2IpLsr2";
//            String consumerSecret ="u8EOJqds1sGgrE4YkLi3h6B5Vux4EHygjWCWKIOESsi7QNhI1R";
//            String twitterToken ="1204131369015750659-G0MAC8Ka2OipYIOBSHxzMFjXyllBzO";
//            String twitterSecret="VvTZl9VHNjbEwWveDQkqjgzO2iHN15FjJQHsYBHMgknvP";
//            TwitterFactory factory = new TwitterFactory();
//            Twitter twitter = factory.getInstance();
//            twitter.setOAuthConsumer(consumerKey, consumerSecret);
//            AccessToken accessToken = new AccessToken(twitterToken, twitterSecret);
//            twitter.setOAuthAccessToken(accessToken);
//            Long tweetId = twitter.getId();
            Status status = twitter.retweetStatus(twitter.getId());
            return tweetId;
         //   System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() + status.getId());
            //makes the reTweet
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void noArgsFuction (String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java twitter4j.examples.tweets.RetweetStatus [status id]");
            System.exit(-1);
        }
        System.out.println("Retweeting the status id - [" + args[0] + "].");
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.retweetStatus(Long.parseLong(args[0]));
            System.out.println("Successfully retweeted status [" + args[0] + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to retweet: " + te.getMessage());
            System.exit(-1);
        }
    }
}


