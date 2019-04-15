package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entity.Usuario;

/**
 * Servlet implementation class ControladorLogIn
 */
@WebServlet("/ControladorLogIn")
public class ControladorLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession(false)!= null){
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
		
		}else{
			
			response.sendRedirect("./index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password= request.getParameter("pass");
		UsuarioDAO miUserDAO = new UsuarioDAOImpl();
		String pass_a_MD5 = miUserDAO.stringAMD5(password);
		Usuario miUser = new Usuario();
		miUser.setNombre(user);
		miUser.setPassword(pass_a_MD5);
	
		Usuario elUser = miUserDAO.findUsuario(miUser);
		
		
		if(elUser != null){
			
			HttpSession session = request.getSession();
			   session.setMaxInactiveInterval(20*60);
			   request.getSession().setAttribute("elUser", miUser);
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
		
		}else{
			
			
			response.sendRedirect("./errorLogIn.html");
		}
		
		
	}

}
