package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PropuestaDAOImpl;
import entity.Usuario;

/**
 * Servlet implementation class ControladorBajaPropuesta
 */
@WebServlet("/ControladorBajaPropuesta")
public class ControladorBajaPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorBajaPropuesta() {
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
			request.setAttribute("propuestas", new PropuestaDAOImpl().getAllPropuestas());

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/baja_propuesta.jsp").forward(request, response);

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

			Usuario unUsuario = (Usuario) request.getSession().getAttribute("elUser");
			request.setAttribute("usuario", unUsuario);
			int prop_id = Integer.parseInt(request.getParameter("propuesta_id"));
			int r = new PropuestaDAOImpl().bajaPropuestaById(prop_id);
			request.setAttribute("propuestas", new PropuestaDAOImpl().getAllPropuestas());

			if (r > 0) {

				request.setAttribute("exito", "Eliminada con éxito");

			} else {

				request.setAttribute("exito", "No se pudo eliminar");

			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/baja_propuesta.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
