package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.AdminService;
import member.model.vo.Member;
import qna.model.vo.QnaNotice;

/**
 * Servlet implementation class AdminQnaNoticeReadServlet
 */
@WebServlet(name = "AdminQnaNoticeRead", urlPatterns = { "/adminQnaNoticeRead" })
public class AdminQnaNoticeReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQnaNoticeReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("member") == null || !((Member)session.getAttribute("member")).getMemberId().equals("admin")) {
			System.out.println("뒤로가기");
			RequestDispatcher rd = ((HttpServletRequest)request).getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			((HttpServletRequest)request).setAttribute("msg", "관리자 계정만 접근이 가능합니다.");
			((HttpServletRequest)request).setAttribute("loc", "/");
			rd.forward(request, response);
		}
		
		int qnaNoticeNo = Integer.parseInt(request.getParameter("qnaNoticeNo"));
		QnaNotice qna = new AdminService().qnaNoticeRead(qnaNoticeNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admin/adminQnaNoticeRead.jsp");
		request.setAttribute("qna", qna);
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
