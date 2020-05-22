package dog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog.model.dao.DogDao;
import dog.model.service.DogService;

/**
 * Servlet implementation class DeleteDogServlet
 */
@WebServlet(name = "DeleteDog", urlPatterns = { "/deleteDog" })
public class DeleteDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dogId = request.getParameter("dogId");
		int result = new DogService().deleteDog(dogId);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/popupmsg.jsp");
		if (result > 0) {
			request.setAttribute("msg", "삭제 되었습니다");
		} else {
			request.setAttribute("msg", "삭제 되지않았습니다");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
