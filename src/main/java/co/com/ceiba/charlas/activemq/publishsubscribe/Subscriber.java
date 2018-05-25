package co.com.ceiba.charlas.activemq.publishsubscribe;

import javax.jms.JMSException;

import co.com.ceiba.charlas.activemq.publishsubscribe.ConfigurationBroker;
import co.com.ceiba.charlas.activemq.publishsubscribe.ProcessorMessage;

public class Subscriber {
	
	private ConfigurationBroker configuration;
	
    public Subscriber(){
    	configuration = ConfigurationBroker.getInstance();
    }
    
    public void receiveMessage(){
    	try {
			configuration.getSession().createConsumer( configuration.getDestination() ).setMessageListener( new ProcessorMessage() );
		} catch (JMSException e) {
			System.err.println("Error receiving consumer: " + e.getMessage());
		}
    }
}
