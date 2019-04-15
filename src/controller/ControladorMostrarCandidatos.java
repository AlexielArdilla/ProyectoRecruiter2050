package controller;

import java.io.IOException;
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
 * Servlet implementation class ControladorMostrarCandidatos
 */
@WebServlet("/ControladorMostrarCandidatos")
public class ControladorMostrarCandidatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorMostrarCandidatos() {
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
			request.setAttribute("candidatos", misCandidatos);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/mostrar_candidatos.jsp").forward(request, response);

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
