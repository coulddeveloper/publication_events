package com.aws.codestar.projecttemplate.model;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.aws.codestar.projectemplates.dao.SnsEvent;

@Component
public class SnsModel {

	 /** AWS SDK credentials. */
	  private AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	        .build();
	  private DynamoDBMapper mapper = new DynamoDBMapper(client);
	  
	  
	  public void saveSnsEvent(SnsEvent snsEvent) {
		    try {
		      mapper.save(snsEvent);
		    } catch (Exception e) {
		    	System.out.println(e.getMessage());
		      throw e;
		    }
		  }

}
