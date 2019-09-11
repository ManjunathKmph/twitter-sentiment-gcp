package com.manju.twitter

import org.scalatest._
import com.manju.twitter.SentimentAnalyser

class SentimentAnalyserTest extends FlatSpec  {

val sentimentAnalyser = new SentimentAnalyser()
	  
  it should "detect not understood" in {
    println(sentimentAnalyser.detectSentiment(""))
    assert(sentimentAnalyser.detectSentiment("") == "NEUTRAL")
  }
  
  it should "detect a negative sentiment" in {
    println(sentimentAnalyser.detectSentiment("I am feeling very sad and frustrated."))
    assert(sentimentAnalyser.detectSentiment("I am feeling very sad and frustrated.") == "NEGATIVE")
  }
  
  it should "detect a neutral sentiment" in {
    println(sentimentAnalyser.detectSentiment("I'm watching a movie"))
    assert(sentimentAnalyser.detectSentiment("I'm watching a movie") == "NEUTRAL")
  }
  
  it should "detect a positive sentiment" in {
    println(sentimentAnalyser.detectSentiment("It was a nice experience."))
    assert(sentimentAnalyser.detectSentiment("It was a nice experience.") == "POSITIVE")
  }
  
  it should "detect a very positive sentiment" in {
    println(sentimentAnalyser.detectSentiment("It was a very nice experience."))
    assert(sentimentAnalyser.detectSentiment("It was a very nice experience.") == "POSITIVE")
  }
  
  it should "Test 6" in {
    println(sentimentAnalyser.detectSentiment("I love this world"))
    assert(sentimentAnalyser.detectSentiment("I love this world") == "POSITIVE")
  }
  
  it should "Test 7" in {
    println(sentimentAnalyser.detectSentiment("@jetblue you have a MUJI store in the JFK terminal but nowhere to get a BAGEL?#YOU"))
    assert(sentimentAnalyser.detectSentiment("@jetblue you have a MUJI store in the JFK terminal but nowhere to get a BAGEL?#YOU") == "NEGATIVE")
  }
  
  it should "Test 8" in {
    println(sentimentAnalyser.detectSentiment("@Seamless almost 2 hours and still no food delivery from Chanpen Thai in NYC. Not pleased and very hungry!!!!!"))
    assert(sentimentAnalyser.detectSentiment("@Seamless almost 2 hours and still no food delivery from Chanpen Thai in NYC. Not pleased and very hungry!!!!!") == "NEGATIVE")
  }
  
  it should "Test 9" in {
    println(sentimentAnalyser.detectSentiment("Seriously @Comcast, why must my wireless signal go out intermittently for hours/days every couple of weeks? I am so over this. #evil"))
    assert(sentimentAnalyser.detectSentiment("Seriously @Comcast, why must my wireless signal go out intermittently for hours/days every couple of weeks? I am so over this. #evil") == "NEGATIVE")
  }
  
  it should "Test 10" in {
    println(sentimentAnalyser.detectSentiment("Heads up Sys #Admins! Keep an eye on #Blackboard social channels tomorrow for an fun contest to get you pumped up for the Fall!"))
    assert(sentimentAnalyser.detectSentiment("Heads up Sys #Admins! Keep an eye on #Blackboard social channels tomorrow for an fun contest to get you pumped up for the Fall!") == "POSITIVE")
  }
}
