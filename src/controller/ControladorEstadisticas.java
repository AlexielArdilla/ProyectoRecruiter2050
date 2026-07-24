package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAOImpl;
import entity.Candidato;
import java.util.List;

/**
 * Servlet implementation class ControladorEstadisticas
 */
@WebServlet("/ControladorEstadisticas")
public class ControladorEstadisticas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorEstadisticas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Este es el ACTUAL!!!!

		if (request.getSession(false) != null) {

			int sel = 0;
			int pre = 0;
			int rech = 0;

			List<Candidato> misCandidatos = new CandidatoDAOImpl().getCandidatos();

			for (Candidato c : misCandidatos) {

				if (c.getEstado().equals("Seleccionado")) {

					sel++;
				} else if (c.getEstado().equals("Preseleccionado")) {

					pre++;
				} else if (c.getEstado().equals("Rechazado")) {

					rech++;
				}

			}

			request.setAttribute("Seleccionados", sel);
			request.setAttribute("Preseleccionados", pre);
			request.setAttribute("Rechazados", rech);

			request.setAttribute("est_listado_labels", "[ \"Seleccionados\", \"Preseleccionados\", \"Rechazados\" ]");

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/estadisticas.jsp").forward(request, response);

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
