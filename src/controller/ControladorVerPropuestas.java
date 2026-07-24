package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Propuesta;
import java.util.List;
import dao.PropuestaDAOImpl;

/**
 * Servlet implementation class ControladorVerPropuestas
 */
@WebServlet("/ControladorVerPropuestas")
public class ControladorVerPropuestas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorVerPropuestas() {
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

			List<Propuesta> misPropuestas = new PropuestaDAOImpl().getAllPropuestas();
			request.setAttribute("propuestas", misPropuestas);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/ver_propuestas.jsp").forward(request, response);

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
