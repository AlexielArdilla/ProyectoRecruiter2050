package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAOImpl;
import dao.CurriculumDAOImpl;
import dao.PropuestaDAOImpl;

/**
 * Servlet implementation class ControladorAsignarPropuesta
 */
@WebServlet("/ControladorAsignarPropuesta")
public class ControladorAsignarPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorAsignarPropuesta() {
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

			request.setAttribute("candidatos", new CandidatoDAOImpl().getCandidatos());
			request.setAttribute("propuestas", new PropuestaDAOImpl().getAllPropuestas());

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/asignar_propuesta.jsp").forward(request, response);

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

			int id_candidato = Integer.parseInt(request.getParameter("candidato_id"));
			int id_propuesta = Integer.parseInt(request.getParameter("prop_id"));

			request.setAttribute("candidatos", new CandidatoDAOImpl().getCandidatos());
			request.setAttribute("propuestas", new PropuestaDAOImpl().getAllPropuestas());

			int r = new CurriculumDAOImpl().cargarpropuestaAcandidato(id_propuesta, id_candidato);

			if (r > 0) {

				request.setAttribute("exito", "Propuesta asignada");

			} else {

				request.setAttribute("exito", "No se pudo asignar");

			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/asignar_propuesta.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
