package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.noticeService;

/**
 * Servlet implementation class NoticeCommentDeleteServlet
 */
@WebServlet(name = "NoticeCommentDelete", urlPatterns = { "/noticeCommentDelete" })
public class NoticeCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 변수에 값 저장
		
		int noticeCommentNo = (Integer.parseInt(request.getParameter("noticeCommentNo")));
		int noticeCommentRef = (Integer.parseInt(request.getParameter("noticeCommentRef")));
		//3. 비지니스 로직
		int result = new noticeService().deleteNoticeCommentNo(noticeCommentNo);
		//4. 결과 처리
		System.out.println("확인 글번호: "+noticeCommentNo+"댓글번호 : "+noticeCommentRef);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("msg", "댓글삭제성공");

		}else {
			request.setAttribute("msg", "댓글삭제실패");

		}
		request.setAttribute("loc", "/noticeView?noticeNo="+noticeCommentRef);
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
