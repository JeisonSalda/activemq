package co.com.ceiba.charlas.activemq.pointtopoint;

import javax.jms.JMSException;


public class Consumer {


    private ConfigurationBroker configuration; 

    
    public Consumer(){
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
