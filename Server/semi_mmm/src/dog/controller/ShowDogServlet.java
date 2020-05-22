package dog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dog.model.service.DogService;
import dog.model.vo.Dog;

/**
 * Servlet implementation class ShowDogServlet
 */
@WebServlet(name = "ShowDog", urlPatterns = { "/showDog" })
public class ShowDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dogId = request.getParameter("dogId");
		Dog dog = new DogService().selectOneDog(dogId);
		String var1 = null;
		String var2 = null;
		String[] var = dog.getVariety().split("/");
		request.setAttribute("oneDog", dog);
		request.setAttribute("var",var);
		request.getRequestDispatcher("/WEB-INF/views/dog/showDog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
