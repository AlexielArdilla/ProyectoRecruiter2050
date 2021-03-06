package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAO;
import dao.CandidatoDAOImpl;
import entity.Candidato;

/**
 * Servlet implementation class ControladorPreseleccionados
 */
@WebServlet("/ControladorPreseleccionados")
public class ControladorPreseleccionados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorPreseleccionados() {
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

			CandidatoDAO miCandidatoDAO = new CandidatoDAOImpl();
			List<Candidato> misCandidatos = miCandidatoDAO.getCandidatos();

			List<Candidato> preseleccionados = new LinkedList<>();

			for (Candidato c : misCandidatos) {

				if (c.getEstado().equals("Preseleccionado")) {

					preseleccionados.add(c);

				}

			}

			request.setAttribute("candidatos", preseleccionados);
			request.setAttribute("titulo", "Preseleccionados");

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/preseleccionados.jsp").forward(request, response);

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
