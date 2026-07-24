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
 * Servlet implementation class ControladorModPropuesta
 */
@WebServlet("/ControladorModPropuesta")
public class ControladorModPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorModPropuesta() {
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

			request.setAttribute("propuestas", new PropuestaDAOImpl().getAllPropuestas());
			Usuario unUsuario = (Usuario) request.getSession().getAttribute("elUser");
			request.setAttribute("usuario", unUsuario);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/mod_propuesta.jsp").forward(request, response);

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

			request.setAttribute("propuestas", new PropuestaDAOImpl().getAllPropuestas());
			Usuario unUsuario = (Usuario) request.getSession().getAttribute("elUser");
			request.setAttribute("usuario", unUsuario);

			int id = Integer.parseInt(request.getParameter("propuesta_id"));
			String texto = request.getParameter("texto");
			Propuesta miPropuesta = new PropuestaDAOImpl().getPropuestaById(id);

			Propuesta propModificada = new Propuesta();
			propModificada.setId(id);
			propModificada.setCargo(miPropuesta.getCargo());
			propModificada.setTexto(texto);

			int r = new PropuestaDAOImpl().modPropuesta(propModificada);

			if (r > 0) {

				request.setAttribute("exito", "Modificación exitosa");

			} else {

				request.setAttribute("exito", "No se pudo modificar");

			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/mod_propuesta.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
