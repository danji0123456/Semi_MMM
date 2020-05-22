package dog.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dog.model.service.DogService;
import dog.model.vo.Dog;

/**
 * Servlet implementation class InsertMyDogServlet
 */
@WebServlet(name = "MyDog", urlPatterns = { "/myDog" })
public class MyDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId= request.getParameter("memberId");
		request.setAttribute("memberId", memberId);
		ArrayList<Dog> dog = new DogService().selectDog(memberId);
		HttpSession session = request.getSession(false);
		session.setAttribute("dog", dog);
		request.getRequestDispatcher("/WEB-INF/views/dog/myDog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
