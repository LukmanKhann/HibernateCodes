package org.jsp.one2oneUni.Controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
	}

}
