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
import dao.CurriculumDAOImpl;
import dao.EducacionDAOImpl;
import dao.ExperienciaDAOImpl;
import dao.LemaDAOImpl;
import dao.PropuestaDAOImpl;
import dao.SkillDAOImpl;
import entity.Candidato;
import entity.Curriculum;
import entity.Propuesta;

/**
 * Servlet implementation class ControladorResume
 */
@WebServlet("/ControladorResume")
public class ControladorResume extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorResume() {
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

			try {
				int cand_id = Integer.parseInt(request.getParameter("candidato_id"));

				Candidato miCandidato = new CandidatoDAOImpl().getCandidatoById(cand_id);
				request.setAttribute("candidato", miCandidato);
				Curriculum miCurriculum = new CurriculumDAOImpl().getCVByIdCandidato(cand_id);
				miCurriculum.setEducaciones(new EducacionDAOImpl().getEducacionByIdCandidato(cand_id));
				miCurriculum.setExperiencias(new ExperienciaDAOImpl().getExperienciasByIDCandidato(cand_id));
				miCurriculum.setSkills(new SkillDAOImpl().getSkillsByIDCandidato(cand_id));
				miCurriculum.setLema(new LemaDAOImpl().getLemaByIdCandidato(cand_id));

				request.setAttribute("curriculum", miCurriculum);
				int prop_id = miCurriculum.getPropuestaId();
				Propuesta miPropuesta = new PropuestaDAOImpl().getPropuestaById(prop_id);
				request.setAttribute("propuesta", miPropuesta);

				getServletContext().getRequestDispatcher("/WEB-INF/jsp/home_resume.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				String exito = "El candidato no cargó su CV aún!";
				request.setAttribute("exito", exito);

				CandidatoDAO miCandidatoDAO = new CandidatoDAOImpl();
				List<Candidato> misCandidatos = miCandidatoDAO.getCandidatos();
				request.setAttribute("candidatos", misCandidatos);

				getServletContext().getRequestDispatcher("/WEB-INF/jsp/mostrar_candidatos.jsp").forward(request,
						response);
			}

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
