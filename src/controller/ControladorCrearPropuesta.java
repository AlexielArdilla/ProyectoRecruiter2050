package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PropuestaDAOImpl;
import entity.Propuesta;
import entity.Usuario;

/**
 * Servlet implementation class ControladorCrearPropuesta
 */
@WebServlet("/ControladorCrearPropuesta")
public class ControladorCrearPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorCrearPropuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession(false) != null) {

			Usuario unUsuario = (Usuario) request.getSession().getAttribute("elUser");
			request.setAttribute("usuario", unUsuario);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/crear_propuesta.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession(false) != null) {

			String texto = request.getParameter("texto");
			String cargo = request.getParameter("titulo");
			Propuesta miPropuesta = new Propuesta();
			miPropuesta.setTexto(texto);
			miPropuesta.setCargo(cargo);
			int r = new PropuestaDAOImpl().cargarPropuesta(miPropuesta);
			Usuario unUsuario = (Usuario) request.getSession().getAttribute("elUser");
			request.setAttribute("usuario", unUsuario);

			if (r > 0) {

				request.setAttribute("exito", "Propuesta cargada con éxito");

			} else {

				request.setAttribute("exito", "Falló la carga de propuesta");

			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/crear_propuesta.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
