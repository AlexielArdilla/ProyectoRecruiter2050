package controller;

import dbConnection.*;

public class PruebaConeccion {
	
	
public static void main(String[] args){
		
	java.sql.Connection con = MyConnection.getConnection();
		
	System.out.println(con);	
	
	}

}
