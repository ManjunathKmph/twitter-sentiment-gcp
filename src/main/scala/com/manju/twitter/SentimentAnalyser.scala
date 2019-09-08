package com.manju.twitter

import com.google.cloud.language.v1.Document
import com.google.cloud.language.v1.Document.Type
import com.google.cloud.language.v1.LanguageServiceClient
import com.google.cloud.language.v1.Sentiment

/**
 * @author Manjunath Kempaiah
 * @version 1.0
 * 
 * Class does the sentiment analysis on the tweets using stanford nlp library.
 *
 */
class SentimentAnalyser {

   val language = LanguageServiceClient.create();
  
  /*
   * Method uses google cloud natural language api to detect the sentiment of the message.
   * >0 -> Positive, <0 -> NEGATIVE, =0 -> Neutral 
   */
  def detectSentiment(message:String): String = {
    //if the message is blank then return the sentiment value as not understood.
    if(message == null || message == "" || message.length() == 0) {
        NOT_UNDERSTOOD.toString()
    }
	
	val doc = Document.newBuilder().setContent(message).setType(Type.PLAIN_TEXT).build();
	
	val sentiment = language.analyzeSentiment(doc).getDocumentSentiment();
	
	if(sentiment.getScore() > 0) {
		POSITIVE.toString()
	} else if(sentiment.getScore() < 0) {
		NEGATIVE.toString()
	} else {
		NEUTRAL.toString()
	}
  }
  
  /*
   * Method will close the NLP client.
   */
  def closeNLPClient() {
    language.close()
  }
  
}
