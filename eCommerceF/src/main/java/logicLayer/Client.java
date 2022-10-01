package logicLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import classes.Stm_site_client;
import classes.Stm_site_session;
import datalayer.Datalayer;

public class Client {
	
	
	
	
	public int createClient(int siteId) {

		

		
		Datalayer datalayer = new Datalayer();
		Stm_site_client client = new Stm_site_client();
		Stm_site_session session = new Stm_site_session();
		

		

		// pedir o nome o client para acessar aqui no ds
		client.setSite_id(siteId);
		client.setClient_ds("filipe");
		datalayer.createClient(client);
		
		/*
		 * sessions = client.getSessions();
		 * System.out.println("site id"+Integer.toString(siteId)+" sessionId"+sessionId)
		 * ; sessions.add(session);
		 * System.out.println("site id6"+Integer.toString(siteId)+" sessionId"+sessionId
		 * ); client.setSessions(sessions);
		 * System.out.println("site id"+Integer.toString(siteId)+" sessionId"+sessionId)
		 * ;
		 */

		return client.getClient_id();
	}

}
