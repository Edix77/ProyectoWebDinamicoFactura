package com.desafiolatam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.desafiolatam.models.Producto;

/**
 * Servlet implementation class CalculadoraVentas
 */
@WebServlet("/")
public class CalculadoraVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		
		Producto producto1 = new Producto("Valvulas de titanio" , "V�lvulas de carrera", 1200000, "valvula");
		Producto producto2 = new Producto("Turbo Full Carrera" , "Turbo de competici�n multimarca", 1700000,"turbo");
		Producto producto3 = new Producto("Kit de Freno Competici�n" , "Juego de discos, balatas, caliper de competici�n", 760000,"kit");
		Producto producto4 = new Producto("Sistema de refrigeraci�n",	"Sistema de enfriamiento motor Carrera", 2300000,"sistema");
		Producto producto5 = new Producto("Plumillas Limpiaparabrisas standar",	"SPlumillas para la lluvia", 10000,"plumilla");
		
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		listaProductos.add(producto4);
		listaProductos.add(producto5);
		
		String cantidad  = request.getParameter("Cantidad");


		request.setAttribute("listaProductos", listaProductos);
		request.getRequestDispatcher("calculadora.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
