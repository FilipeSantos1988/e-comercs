package logicLayer;

import java.sql.Date;

import classes.Stm_site_session;
import datalayer.Datalayer;

public class SessionAcess {

	private int siteId;
	private String sessionId;
	private int clientId;
	private Date actualDate;
	
	
	
	
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
	
	
	public void updateSession(String session_Tk, Date updateD) {

		Datalayer datalayer = new Datalayer();
		Stm_site_session session = new Stm_site_session();
		session = datalayer.getSessionByName(session_Tk);
		session.setUpdated_dt(updateD);
		datalayer.updateSession(session);
	}
	
	
	
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Date getActualDate() {
		return actualDate;
	}
	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}
	
	
	
	

	
}
