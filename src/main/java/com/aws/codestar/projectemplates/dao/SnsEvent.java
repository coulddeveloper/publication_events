package com.aws.codestar.projectemplates.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = Tablenames.SNS_EVENT)
public class SnsEvent {
	private String snsTopicArn;
	private String snsPublishTime;
	private String lambdaReceiveTime;
	private String snsMessage;
	private String snsMessageId;

	public SnsEvent() {
	}

	public SnsEvent(String snsTopicArn) {
		this.snsTopicArn = snsTopicArn;
	}

	@DynamoDBRangeKey(attributeName = "SnsPublishTime")
	public String getSnsPublishTime() {
		return snsPublishTime;
	}

	public void setSnsPublishTime(String snsPublishTime) {
		this.snsPublishTime = snsPublishTime;
	}
	
	@DynamoDBHashKey(attributeName = "SnsTopicArn")
	public String getSnsTopicArn() {
		return snsTopicArn;
	}

	public void setSnsTopicArn(String snsTopicArn) {
		this.snsTopicArn = snsTopicArn;
	}

	

	@DynamoDBAttribute(attributeName = "lambdaReceiveTime")
	public String getLambdaReceiveTime() {
		return lambdaReceiveTime;
	}

	public void setLambdaReceiveTime(String lambdaReceiveTime) {
		this.lambdaReceiveTime = lambdaReceiveTime;
	}

	@DynamoDBAttribute(attributeName = "snsMessage")
	public String getSnsMessage() {
		return snsMessage;
	}

	public void setSnsMessage(String snsMessage) {
		this.snsMessage = snsMessage;
	}

	@DynamoDBAttribute(attributeName = "snsMessageId")
	public String getSnsMessageId() {
		return snsMessageId;
	}

	public void setSnsMessageId(String snsMessageId) {
		this.snsMessageId = snsMessageId;
	}
}
