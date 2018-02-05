package com.aws.codestar.projecttemplates.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.aws.codestar.projectemplates.dao.SnsEvent;
import com.aws.codestar.projecttemplate.model.SnsModel;

public class SnsSubscriberHandler implements RequestHandler<SNSEvent, String> {

	
	private SnsModel snsModel;
	
 
	@Override
    public String handleRequest(SNSEvent event, Context context) {
        context.getLogger().log("Received event: " + event);
        String message = event.getRecords().get(0).getSNS().getMessage();
        context.getLogger().log("From SNS: " + message);
        SnsEvent snsEvent = new SnsEvent();
        
        snsEvent.setSnsTopicArn(event.getRecords().get(0).getSNS().getTopicArn());
       
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        snsEvent.setSnsPublishTime(event.getRecords().get(0).getSNS().getTimestamp().toString());//event.getRecords().get(0).getSNS().getTimestamp().toString());
        
        snsEvent.setLambdaReceiveTime(dateFormat.format(date).toString());
        snsEvent.setSnsMessage(event.getRecords().get(0).getSNS().getMessage());
        snsEvent.setSnsMessageId(event.getRecords().get(0).getSNS().getMessageId());
        
        snsModel = new SnsModel();
        snsModel.saveSnsEvent(snsEvent);
        return message;
    }

	public SnsModel getSnsModel() {
		return snsModel;
	}
	
	public void setSnsModel(SnsModel snsModel) {
		this.snsModel = snsModel;
	}
}
