package com.leetcode;

import java.util.*;

public class Twitter {
    public class Tweet {
        private int tweetId;
        private int userId;
        private int time;

        public Tweet(int time, int userId, int tweetId) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.time = time;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public Map<Integer, List<Tweet>> userIdToTweetMap;
    public Map<Integer, List<Integer>> userIdToFolloweeMap;
    public int cnt;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userIdToTweetMap = new HashMap<>();
        userIdToFolloweeMap = new HashMap<>();
        cnt = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        cnt++;
        if (!userIdToTweetMap.containsKey(userId)) {
            userIdToTweetMap.put(userId, new ArrayList<>());
        }
        userIdToTweetMap.get(userId).add(new Tweet(cnt, userId, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followees = userIdToFolloweeMap.get(userId);
        PriorityQueue<Tweet> tweetsPQ = new PriorityQueue<Tweet>(10, (t1, t2) -> t1.time - t2.time);
        Map<Integer, Integer> userIdIndex = new HashMap<>();
        if (userIdToTweetMap.containsKey(userId)) {
            tweetsPQ.add(userIdToTweetMap.get(userId).get(0));
        }
        if (followees != null) {
            for (Integer followee : followees) {
                List<Tweet> followeeTweets = userIdToTweetMap.get(followee);
                if (followeeTweets != null) {
                    tweetsPQ.add(followeeTweets.get(0));
                }
            }
        }
        List<Tweet> userTweets = userIdToTweetMap.get(userId);
        if (userTweets != null) {
            tweetsPQ.add(userTweets.get(0));
        }
        int n = 0;
        List<Integer> tweets = new ArrayList<>();
        while (tweetsPQ.size() > 0 && n < 10) {
            Tweet top = tweetsPQ.poll();
            if (!userIdIndex.containsKey(top.userId)) userIdIndex.put(top.userId, 1);
            if (userIdToTweetMap.get(top.userId).size() > userIdIndex.get(top.userId)) {
                tweets.add(userIdToTweetMap.get(top.userId).get(userIdIndex.get(top.userId)).tweetId);
                userIdIndex.computeIfPresent(top.userId, (k, v) -> v + 1);
            }
            n++;
        }
        return tweets;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userIdToFolloweeMap.containsKey(followerId)) {
            userIdToFolloweeMap.put(followerId, new ArrayList<>());
        }
        userIdToFolloweeMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userIdToFolloweeMap.containsKey(followerId)) {
            return;
        }
        userIdToFolloweeMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */