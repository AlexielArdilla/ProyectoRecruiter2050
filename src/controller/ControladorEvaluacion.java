package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calculo.Calculadora;
import calculo.Viabilidad;
import dao.CandidatoDAOImpl;
import dao.CurriculumDAOImpl;
import dao.EducacionDAOImpl;
import dao.ExperienciaDAOImpl;
import dao.SkillDAOImpl;
import entity.Candidato;
import entity.Experiencia;
import entity.Curriculum;
import entity.*;

/**
 * Servlet implementation class ControladorEvaluacion
 */
@WebServlet("/ControladorEvaluacion")
public class ControladorEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorEvaluacion() {
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

			int candidato_id = Integer.parseInt(request.getParameter("candidato_id"));
			int cabecera = Integer.parseInt(request.getParameter("cabecera"));
			int mision = Integer.parseInt(request.getParameter("mision"));

			// experiencia skill educacion

			Curriculum miCV = new CurriculumDAOImpl().getCVByIdCandidato(candidato_id);

			List<Experiencia> misExperiencias = new ExperienciaDAOImpl().getExperienciasByIDCandidato(candidato_id);
			List<Skill> misSkills = new SkillDAOImpl().getSkillsByIDCandidato(candidato_id);
			List<Educacion> misEducaciones = new EducacionDAOImpl().getEducacionByIdCandidato(candidato_id);

			int experiencias_cant = misExperiencias.size();
			int skill_cant = misSkills.size();
			int educacion_cant = misEducaciones.size();

			String experiencias_scores[] = new String[experiencias_cant];
			String skills_scores[] = new String[skill_cant];
			String educaciones_scores[] = new String[educacion_cant];
			int indice = 0;

			for (Experiencia e : misExperiencias) {

				experiencias_scores[indice] = request.getParameter("experiencia" + e.getId());
				indice++;

			}

			int indice2 = 0;

			for (Skill s : misSkills) {

				skills_scores[indice2] = request.getParameter("skill" + s.getId());

				indice2++;
			}

			int indice3 = 0;

			for (Educacion e : misEducaciones) {

				educaciones_scores[indice3] = request.getParameter("educacion" + e.getId());

				indice3++;
			}

			// Evaluacion!!!
			Viabilidad cabecera_viabilidad = new Calculadora().puntajeViable(cabecera);
			Viabilidad mision_viabilidad = new Calculadora().puntajeViable(mision);
			Viabilidad experiencia_viabilidad = new Calculadora().arrayViable(experiencias_scores);
			Viabilidad skill_viabilidad = new Calculadora().arrayViable(skills_scores);
			Viabilidad educacion_viabilidad = new Calculadora().arrayViable(educaciones_scores);

			request.setAttribute("cabecera", cabecera_viabilidad);
			request.setAttribute("mision", mision_viabilidad);
			request.setAttribute("experiencia", experiencia_viabilidad);
			request.setAttribute("skill", skill_viabilidad);
			request.setAttribute("educacion", educacion_viabilidad);
			request.setAttribute("candidato_id", candidato_id);
			request.setAttribute("nombre_candidato",
					new CandidatoDAOImpl().getCandidatoById(candidato_id).getNombre_apel());

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/evaluacion_candidato.jsp").forward(request,
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
			String evaluacion = request.getParameter("estado");

			int r = new CandidatoDAOImpl().actualizarEstado(candidato_id, evaluacion);

			if (r > 0) {

				request.setAttribute("cabecera", "Ya evaluado");
				request.setAttribute("mision", "Ya evaluado");
				request.setAttribute("experiencia", "Ya evaluado");
				request.setAttribute("skill", "Ya evaluado");
				request.setAttribute("educacion", "Ya evaluado");
				request.setAttribute("candidato_id", "Ya evaluado");

				request.setAttribute("exito", "Se evaluó correctamente");

			} else {

				request.setAttribute("cabecera", "No evaluado");
				request.setAttribute("mision", "No evaluado");
				request.setAttribute("experiencia", "No evaluado");
				request.setAttribute("skill", "No evaluado");
				request.setAttribute("educacion", "No evaluado");
				request.setAttribute("candidato_id", "No evaluado");

				request.setAttribute("exito", "Error al evaluar");

			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/evaluacion_candidato.jsp").forward(request,
					response);

		} else {

			response.sendRedirect("./index.html");
		}
	}

}
