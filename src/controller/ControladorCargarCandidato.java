package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAOImpl;
import entity.Candidato;

/**
 * Servlet implementation class ContyroladorCargarCandidato
 */
@WebServlet("/ControladorCargarCandidato")
public class ControladorCargarCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorCargarCandidato() {
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

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/cargar_candidato.jsp").forward(request, response);

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

			String nombre = request.getParameter("nombre");
			int edad = Integer.parseInt(request.getParameter("edad"));
			int dni = Integer.parseInt(request.getParameter("dni"));
			String estado = request.getParameter("estado");

			Candidato candidato = new Candidato();
			candidato.setNombre_apel(nombre);
			candidato.setEdad(edad);
			candidato.setDni(dni);
			candidato.setEstado(estado);

			int r = new CandidatoDAOImpl().cargarCandidato(candidato);

			if (r > 0) {

				request.setAttribute("exito", "Candidato cargado con éxito!");

			} else {

				request.setAttribute("exito", "No se pudo cargar el candidato!");
			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/cargar_candidato.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
