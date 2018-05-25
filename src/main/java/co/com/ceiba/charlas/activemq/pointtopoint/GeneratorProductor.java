package co.com.ceiba.charlas.activemq.pointtopoint;

public class GeneratorProductor {
	
	 public static void main( String[] args )
	 {
		 
		 for(int i = 0; i < 200; i++){
			 
			 Productor productor = new Productor();
			 productor.sendMessage("Hola prueba charla " + i);
			 
			 
		 }
		 
		 ConfigurationBroker.getInstance().closeResources();
		 
	 }

}
