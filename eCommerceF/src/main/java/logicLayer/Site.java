package logicLayer;

import classes.Stm_site;
import datalayer.Datalayer;

public class Site {

	
	public int acessSite() {

		Datalayer datalayer = new Datalayer();
		Stm_site site = new Stm_site();
		site.setSite_id(1);
		datalayer.getSiteInformaction(site);
		return site.getSite_id();

	}
	
	
	
}
