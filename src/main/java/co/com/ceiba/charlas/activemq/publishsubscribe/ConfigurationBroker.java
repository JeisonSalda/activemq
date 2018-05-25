package co.com.ceiba.charlas.activemq.publishsubscribe;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public final class ConfigurationBroker {
	
	private static final String SERVIDOR_BROKER = "tcp://localhost:61616?jms.prefetchPolicy.queuePrefetch=1";
	private static ConfigurationBroker instance;
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination destination;
	
	public Session getSession() {
		return session;
	}
	
	public Destination getDestination() {
		return destination;
	}

	public static synchronized ConfigurationBroker getInstance(){
		if( instance == null ){
			instance = new ConfigurationBroker();
		}
		return instance;
	}
	
	private ConfigurationBroker(){
		try{
			connectionFactory = new ActiveMQConnectionFactory(SERVIDOR_BROKER);
	        // Create a Connection
	        connection = connectionFactory.createConnection();
	        connection.start();
	        // Create a Session
	        session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
	        // Create the destination (Topic or Queue)
	        destination = session.createTopic("TOPIC.EJEMPLO");
		}catch(Exception e ){
			System.err.println(" Error: " + e.getMessage());
		}
		
	}
		
	public void closeResources(){
		try {
			session.close();
			connection.close();
		} catch (JMSException e) {
			System.err.println(" Error: " + e.getMessage());
		}
	}

}
