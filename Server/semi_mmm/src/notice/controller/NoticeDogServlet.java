package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dog.model.service.DogService;
import dog.model.vo.Dog;
import notice.model.vo.dogList;
import notice.service.noticeService;


/**
 * Servlet implementation class NoticeDogServlet
 */
@WebServlet(name = "NoticeDog", urlPatterns = { "/noticeDog" })
public class NoticeDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		HttpSession session = request.getSession(false);
		int count = new noticeService().getDogCount(memberId);
		
		if (count == 0 ) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "강아지를 등록하세요.");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		} else {
			Dog dogList = new noticeService().noticeDogWrite(memberId);
			
			ArrayList<Dog> dog = new DogService().selectDog(memberId);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/imgeNotice/imgeNoticeWrite.jsp");
			session.setAttribute("dog", dog);
			request.setAttribute("dog", dogList);


		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
