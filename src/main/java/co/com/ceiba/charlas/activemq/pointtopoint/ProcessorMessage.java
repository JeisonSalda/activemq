package co.com.ceiba.charlas.activemq.pointtopoint;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ProcessorMessage implements MessageListener {

	public void onMessage(Message message) {
		try{
			if (message instanceof TextMessage) {
	            TextMessage textMessage = (TextMessage) message;
	            String text = textMessage.getText();
	            System.out.println("Received: " + text);
	        } else {
	            System.out.println("Received: " + message);
	        }
			
			Thread.sleep(1000);
			
			message.acknowledge();
		}catch(JMSException | InterruptedException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}

}
