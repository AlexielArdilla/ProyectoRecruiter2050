package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAOImpl;
import entity.Candidato;

/**
 * Servlet implementation class ControladorBajaCandidato
 */
@WebServlet("/ControladorBajaCandidato")
public class ControladorBajaCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorBajaCandidato() {
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

			List<Candidato> candidatos = new CandidatoDAOImpl().getCandidatos();

			request.setAttribute("candidatos", candidatos);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/baja_candidato.jsp").forward(request, response);

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

			int baja = Integer.parseInt(request.getParameter("baja"));

			int r = new CandidatoDAOImpl().bajaCandidatoById(baja);

			if (r > 0) {

				request.setAttribute("exito", "Exito al dar de baja");

			} else {

				request.setAttribute("exito", "No se pudo dar de baja");
			}

			List<Candidato> candidatos = new CandidatoDAOImpl().getCandidatos();

			request.setAttribute("candidatos", candidatos);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/baja_candidato.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
