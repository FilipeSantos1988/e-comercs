package logicLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import classes.Stm_site_session;
import datalayer.Datalayer;

public class Session {

	int siteId;
	int clienteId;
	String session_tk;
	
	
	
	public void createSession(int siteId,String sessionTk,int clientId,Long createdDate) {
		
		
		Datalayer dataLayer= new Datalayer();
		Stm_site_session session = new Stm_site_session();
		session.setClient_id(clientId);
		session.setSite_id(siteId);
		session.setSession_tk(sessionTk);
		session.setCreated_dt(new Date(createdDate));
		session.setUpdated_dt(new Date(createdDate));
		dataLayer.createSession(session);
		
		
	}
	
	
	
	
	
	
	/*public boolean getSession(SessionAcess sessionAcess) {
		
	
		
		
		
		
	}*/
	
	
	
	
	
	public Boolean checkAcess(String sessionTk) {

		Datalayer datalayer = new Datalayer();

		if (datalayer.getSessionByName(sessionTk) != null) {
			return true;
		} else {
			return false;
		}

	}
	
	
	
	
	public void updateSession(String session_Tk, Date updateD) {

		Datalayer datalayer = new Datalayer();
		Stm_site_session session = new Stm_site_session();
		session = datalayer.getSessionByName(session_Tk);
		session.setUpdated_dt(updateD);
		datalayer.updateSession(session);
	}
	
	
}
