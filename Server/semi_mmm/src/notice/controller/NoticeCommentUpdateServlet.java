package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import dog.model.vo.Dog;
import notice.model.vo.Notice;
import notice.service.noticeService;

/**
 * Servlet implementation class NoticeCommentUpdateServlet
 */
@WebServlet(name = "NoticeCommentUpdate", urlPatterns = { "/noticeCommentUpdate" })
public class NoticeCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		int noticeCommentNo = Integer.parseInt(request.getParameter("noticeCommentNo"));
		int noticeCommentRef = Integer.parseInt(request.getParameter("noticeCommentRef"));
		String noticeCommentContent = request.getParameter("noticeCommentContent");

		
		System.out.println("댓글 수정 값 확인 : "+noticeCommentNo+noticeCommentRef+noticeCommentContent);
		
		int result = new noticeService().noticeCommentUpdate(noticeCommentNo, noticeCommentRef, noticeCommentContent);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
	
		
		if (result > 0) {
			request.setAttribute("msg", " 등록되었습니다.");
			request.setAttribute("loc", "/noticeView?noticeNo="+noticeCommentRef);
			
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
