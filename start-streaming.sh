#!/bin/sh

#packing project jar
sbt assembly

#submit the jar to spark to run
spark-submit --class com.manju.twitter.TwitterStreaming target/twitter-sentiment-assembly-1.0.jar
