package com.desafiolatam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.models.Producto;

@WebServlet("/factura")
public class Factura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// capturando parámetros
		String nombre = request.getParameter("nombre");
		String empresa = request.getParameter("empresa");
		String rut = request.getParameter("rut");
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String pais = request.getParameter("pais");

		// capturar la cantidad ingresada de cada producto
		Integer item01 = Integer.parseInt(request.getParameter("valvula"));
		Integer item02 = Integer.parseInt(request.getParameter("turbo"));
		Integer item03 = Integer.parseInt(request.getParameter("kit"));
		Integer item04 = Integer.parseInt(request.getParameter("sistema"));
		Integer item05 = Integer.parseInt(request.getParameter("plumilla"));

		Integer i01 = 0;
		Integer i02 = 0;
		Integer i03 = 0;
		Integer i04 = 0;
		Integer i05 = 0;
		
		
		
		
		if (item01 == 0 ) {
			i01 = Integer.parseInt(request.getParameter("valvula"));
		}

		// Capturar valor unitario de cada producto

		String valvulaVU = request.getParameter("valvulaVU");
		String turboVU = request.getParameter("turboVU");
		String kitVU = request.getParameter("kitVU");
		String sistemaVU = request.getParameter("sistemaVU");
		String plumillaVU = request.getParameter("plumillaVU");
		Integer vu01 = 0;
		Integer vu02 = 0;
		Integer vu03 = 0;
		Integer vu04 = 0;
		Integer vu05 = 0;

		if (valvulaVU != "") {
			vu01 = Integer.parseInt(request.getParameter("valvulaVU"));
		}
		if (turboVU != "") {
			vu02 = Integer.parseInt(request.getParameter("turboVU"));
		}
		if (kitVU != "") {
			vu03 = Integer.parseInt(request.getParameter("kitVU"));
		}
		if (sistemaVU != "") {
			vu04 = Integer.parseInt(request.getParameter("sistemaVU"));
		}
		if (plumillaVU != "") {
			vu05 = Integer.parseInt(request.getParameter("plumillaVU"));
		}

		// Validar

		if (nombre.equals("") || empresa.equals("") || rut.equals("") || direccion.equals("") || ciudad.equals("")
				|| pais.equals("") || nombre == null || empresa == null || rut == null || direccion == null
				|| ciudad == null || pais == null) {
			String msgError = "Te faltó ingresar parte de los datos del cliente, por favor verifícalos";

			request.setAttribute("msgError", msgError);
			request.getRequestDispatcher("/formularioIngreso").forward(request, response);
		} else {

			Integer valorNeto = 0;
			Double descuento = 0.0;
			Integer valorTotal = 0;
			Integer valvulaVT = 0;
			Integer turboVT = 0;
			Integer kitVT = 0;
			Integer sistemaVT = 0;
			Integer plumillaVT = 0;

			ArrayList<Producto> listaProductos = new ArrayList<Producto>();

			if (item01 > 0) {
				valvulaVT = vu01 * item01;
				Producto producto1 = new Producto("Valvulas de titanio", "Válvulas de carrera", 1200000, valvulaVT,
						item01);
				listaProductos.add(producto1);
			}
			if (item02 > 0) {
				turboVT = vu02 * item02;
				Producto producto2 = new Producto("Turbo Full Carrera", "Turbo de competición multimarca", 170000,
						turboVT, item02);
				listaProductos.add(producto2);
			}
			if (item03 > 0) {
				kitVT = vu03 * item03;
				Producto producto3 = new Producto("Kit de Freno Competición",
						"Juego de discos, balatas, caliper de competición", 760000, kitVT, item03);
				listaProductos.add(producto3);
			}
			if (item04 > 0) {
				sistemaVT = vu04 * item04;
				Producto producto4 = new Producto("Sistema de refrigeración", "Sistema de enfriamiento motor Carrera",
						2300000, sistemaVT, item04);
				listaProductos.add(producto4);
			}
			if (item05 > 0) {
				plumillaVT = vu05 * item05;

				Producto producto5 = new Producto("Plumillas Limpiaparabrisas standar", "SPlumillas para la lluvia",
						10000, plumillaVT, item05);
				listaProductos.add(producto5);
			}

			valorNeto = valvulaVT + turboVT + kitVT + sistemaVT + plumillaVT;

			if (valorNeto > 0) {
				descuento = valorNeto * 0.1;
				valorTotal = (int) (valorNeto - descuento);
			}

			// clave valor, pasando valores desde el Servlet al .jsp
			request.setAttribute("nombre", nombre);
			request.setAttribute("empresa", empresa);
			request.setAttribute("rut", rut);
			request.setAttribute("direccion", direccion);
			request.setAttribute("ciudad", ciudad);
			request.setAttribute("pais", pais);
			request.setAttribute("listaProductos", listaProductos);
			request.setAttribute("valorNeto", valorNeto);
			request.setAttribute("valorTotal", valorTotal);

			request.getRequestDispatcher("factura.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}