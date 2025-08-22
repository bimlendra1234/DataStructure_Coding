// Leetcode : 355. Design Twitter

// *********
// Approach
/*
    1. Each user maintains:
        - own tweets list (newest first)
        - set of followees
    2. postTweet():
        - create user if not exist
        - add new Tweet(timeCounter, tweetId) at head
    3. follow()/unfollow():
        - maintain followees set for the follower
    4. getNewsFeed():
        - do K-way merge of (self + followees) tweets
        - use maxHeap ordered by tweet.time
        - always pick the most recent tweet, push next from that list
        - collect max 10 tweets
    5. Return result
*/

class Tweet implements Comparable<Tweet>{
    int tweetId;
    int time;

    Tweet(int t, int tId) {
        this.time = t;
        this.tweetId = tId;
    }

    public int compareTo(Tweet that) {
        // Sort in decreasing order, need most recent one
        return that.time - this.time;
    }
}

class User {
    // will have used id, self tweet and list of follower
    int userID;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User (int userId) {
        this.userID = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t); // insertion at head
    }

    public void addFollower(int userId) {
        followers.add(userId);
    }

    public void removeFollower(int userId) {
        followers.remove(userId);
    }    
}


class Twitter {
    // map that has user id and userObj
    Map<Integer, User> userMap;
    int timeCounter; // to maintain recent tweet
    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        // if user not in map add it (userId, new userwith that id) and then add tweet
        if(!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        // get that user and add the new tweet
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // if user with userId do not exist return from here
        if(!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        // Add self tweet + follower tweets
        User user = userMap.get(userId);
        for(int followerId : user.followers) { // get follower tweet
            // need at max 10 tweets
            int count = 0;
            for(Tweet tweet : userMap.get(followerId).tweets) {
                pq.offer(tweet);
                count++;
                if(count > 10) {
                    break;
                }
            }
        }
        int count = 0;
        for(Tweet tweet : user.tweets) {
            pq.offer(tweet);
            count++;
            if(count > 10) {
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty() && index <10) {
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            index++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        // If both do not exist in user map then insert new
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        // If A follow B, then A can see all tweets of B, but b cant see A tweets
        // jo banda follow kar raha hai i.e followerId can see followee i.e followeeId tweet

        // get user of followerId and add followee in its follower list
        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // if any of both user do not exist return from here itself
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }
        User user = userMap.get(followerId);
        user.removeFollower(followeeId);

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