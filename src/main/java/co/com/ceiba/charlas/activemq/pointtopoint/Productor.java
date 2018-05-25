package co.com.ceiba.charlas.activemq.pointtopoint;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

public class Productor {
	
	private MessageProducer messageProducer;
	private ConfigurationBroker configuration;
	
	public Productor(){
		configuration = ConfigurationBroker.getInstance();
		try {
			messageProducer = configuration.getSession().createProducer( configuration.getDestination() );
			messageProducer.setDeliveryMode( DeliveryMode.PERSISTENT );
		} catch (JMSException e) {
			System.err.println("Error " + e.getMessage());
		}
	}
    
    public void sendMessage(String text){
    	try {
    		TextMessage message = configuration.getSession().createTextMessage(text);
			messageProducer.send(message);			
		} catch (JMSException e) {
			System.err.println("Error " + e.getMessage());
		}finally{
			
		}
    	
    	
    }

}
