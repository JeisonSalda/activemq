package co.com.ceiba.charlas.activemq.publishsubscribe;

import co.com.ceiba.charlas.activemq.publishsubscribe.ConfigurationBroker;

public class GeneratorPublisher {
	
	public static void main(String args[]){
		
		for(int i = 0; i < 200; i++){
			 
			 Publisher publisher = new Publisher();
			 publisher.sendMessage("Hola prueba charla " + i);
			 
			 
		 }
		 
		 ConfigurationBroker.getInstance().closeResources();
		
	}

}
