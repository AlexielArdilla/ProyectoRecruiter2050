package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PassCandidatoDAOImpl;
import entity.PassCandidato;

/**
 * Servlet implementation class ControladorVerPassCandidatos
 */
@WebServlet("/ControladorVerPassCandidatos")
public class ControladorVerPassCandidatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorVerPassCandidatos() {
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

			String user = request.getParameter("candidato_user");
			int r = new PassCandidatoDAOImpl().borrarPassCandidatoByUser(user);

			List<PassCandidato> misPass = new PassCandidatoDAOImpl().getAllPassCandidatos();
			request.setAttribute("passCandidatos", misPass);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/ver_pass_candidatos.jsp").forward(request, response);

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
