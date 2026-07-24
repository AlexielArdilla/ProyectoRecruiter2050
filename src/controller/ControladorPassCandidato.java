package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAOImpl;
import dao.PassCandidatoDAOImpl;
import entity.Candidato;

/**
 * Servlet implementation class ControladorPassCandidato
 */
@WebServlet("/ControladorPassCandidato")
public class ControladorPassCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorPassCandidato() {
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

			List<Candidato> misCandidatos = new CandidatoDAOImpl().getCandidatos();
			request.setAttribute("candidatos", misCandidatos);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/generar_pass_candidato.jsp").forward(request,
					response);

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

			int candidato_id = Integer.parseInt(request.getParameter("candidato_id"));
			String user = request.getParameter("User");
			String nuevoPass = request.getParameter("NuevoPass");
			String nuevoPassRep = request.getParameter("NuevoPassRep");

			int r = new PassCandidatoDAOImpl().cargarPassCandidatoByCandId(user, nuevoPass, candidato_id);

			if (r > 0) {

				request.setAttribute("exito", "Carga exitosa");
			} else {

				request.setAttribute("exito", "Error al cargar");
			}

			List<Candidato> misCandidatos = new CandidatoDAOImpl().getCandidatos();
			request.setAttribute("candidatos", misCandidatos);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/generar_pass_candidato.jsp").forward(request,
					response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
