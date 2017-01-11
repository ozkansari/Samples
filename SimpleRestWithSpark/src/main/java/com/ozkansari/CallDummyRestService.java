package com.ozkansari;

import static spark.Spark.post;
import static spark.Spark.setPort;
import spark.Request;
import spark.Response;
import spark.Route;


public class CallDummyRestService {

	public static void main(String [] args) {
		
		DummyRestService.startRestService();
		
	}
	
	/**
	 * Dummy REST Service to call from RESTWebserviceClient
	 */
	private static class DummyRestService implements Runnable {
		
		private static Thread t;
		
		@Override
		public void run() {
			
			setPort(9090); // Spark will run on port 9090
			
			Route route = new Route("/hello","application/json") {
	            @Override
	            public Object handle(Request request, Response response) {
	            	System.out.println(request.body());
	                return request.body();
	            }
	        };
			post(route);
		}
		
		public static void startRestService(){
			t = new Thread(new DummyRestService());
	        t.start();
		}
		
		public static void stopRestService(){
	        t.interrupt();
		}
	}

}
