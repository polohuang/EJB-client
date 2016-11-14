package com.paul.client.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.paul.UserCRUD;

public class JBossConnection {
	public static UserCRUD getConnection() throws NamingException {
		Context ctx = new InitialContext();
		UserCRUD bean = (UserCRUD) ctx.lookup("ejb:/EJB-test//UserCRUDBean!com.paul.UserCRUD");
		return bean;
	}
}
