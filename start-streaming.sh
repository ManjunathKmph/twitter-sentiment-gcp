#!/bin/sh

#packing project jar
sbt assembly

#submit the jar to spark to run
spark-submit --packages io.grpc:grpc-okhttp:1.23.0,io.grpc:grpc-core:1.23.0,io.netty:netty-handler:4.1.39.Final,io.netty:netty-tcnative-boringssl-static:2.0.25.Final --class com.manju.twitter.TwitterStreaming target/scala-2.11/twitter-sentiment-assembly-1.0.jar
