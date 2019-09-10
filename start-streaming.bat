::Script to start the spark streaming to fetch tweets from twitter.

::command to build the twitter streaming jar file.
call sbt assembly

spark-submit --class com.manju.twitter.TwitterStreaming target/twitter-sentiment-assembly-1.0.jar
