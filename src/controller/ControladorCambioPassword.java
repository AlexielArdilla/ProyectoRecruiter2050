package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entity.Usuario;

/**
 * Servlet implementation class ControladorCambioPassword
 */
@WebServlet("/ControladorCambioPassword")
public class ControladorCambioPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorCambioPassword() {
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

			Usuario unUsuario = (Usuario) request.getSession().getAttribute("elUser");
			request.setAttribute("usuario", unUsuario);

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/cambio_contrasenia.jsp").forward(request, response);

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

			String passAnterior = request.getParameter("PassAnt");

			Usuario unUsuario = (Usuario) request.getSession().getAttribute("elUser");
			request.setAttribute("usuario", unUsuario);

			UsuarioDAO miUserDAO = new UsuarioDAOImpl();
			String pass_a_MD5 = miUserDAO.stringAMD5(passAnterior);
			Usuario miUser = new Usuario();
			miUser.setNombre(unUsuario.getNombre());// Ojo que tiene que estar
													// logueado
			miUser.setPassword(pass_a_MD5);

			Usuario elUser = miUserDAO.findUsuario(miUser);

			if (elUser != null) {

				String nuevoPass = request.getParameter("NuevoPass");
				String passMD5 = new UsuarioDAOImpl().stringAMD5(nuevoPass);
				int r = -1;
				//comentado para que no me cambien los passwords!!!
				//int r = new UsuarioDAOImpl().cambiarPassword(miUser, passMD5);

				if (r > 0) {

					request.setAttribute("exito", "Cambio de password exitoso");

				} else {

					request.setAttribute("exito", "No se pudo cambiar el password");

				}

			} else {

				request.setAttribute("exito", "Password anterior incorrecto");

			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/cambio_contrasenia.jsp").forward(request, response);

		} else {

			response.sendRedirect("./index.html");
		}

	}

}
