package com.desafiolatam.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
	
	// ESTA CLASE ES MUY GENERICA PARA BASES DE DATOS
	
	//datos para conectarse a una base de datos
	private String sServidor = "localhost"; //localhost es mi computador ip 217.0.0.1
	private String sUsuario = "root";
	private String sPassword = "123456";
	private int iPuerto = 3306; //puerto con que trabaja MYSQL
	private String sBaseDatos = "javag6"; //BASE DE DATOS CREADA ANTERIORMENTE EN OTRO DIA DE CLASES
	
	private String sServer = ""; // EN ESTA VARIABLE SE GUARDA TODA LA UNFORMACION DE CONECCION
	
	private static Connection conexion = null;
	
	public BaseDatos() {
		super();
	}

	public Connection datos() {
		//this.sBaseDatos = baseDatos;
		//recibimos el nombre de la base de datos
		this.sServer = "jdbc:mysql://"+this.sServidor+":"+
						this.iPuerto+"/"+sBaseDatos;
		//jdbc:mysql://localhost:3306/javag5
		
		//registremos el driver mysql
		try {
			//Class.forName("com.mysql.jdbc.Driver");//Mysql
			Class.forName("com.mysql.cj.jdbc.Driver");//MariaDB
			
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.err.println("Error al registrar el driver Mysql: "+e);
			// Al detectar error termina el flujo
			//System.exit(0);
		}
		
		//conexion a mysql establecida
		
		try {
			conexion = DriverManager.getConnection(this.sServer,this.sUsuario,this.sPassword);// ACA SE PRODUCE LA CONECCION A LA BASE DE DATOS
		} catch (SQLException e) {
			System.err.println("Error al conectar a Mysql: "+e);
			// Al detectar error termina el flujo
			//System.exit(0);
		}

		return conexion;
		
	}
}


