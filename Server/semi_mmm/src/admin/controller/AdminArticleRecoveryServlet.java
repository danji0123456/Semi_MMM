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

/**
 * Servlet implementation class AdminArticleRecoveryServlet
 */
@WebServlet(name = "AdminArticleRecovery", urlPatterns = { "/adminArticleRecovery" })
public class AdminArticleRecoveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminArticleRecoveryServlet() {
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

		int articleNoticeNo = Integer.parseInt(request.getParameter("articleNoticeNo"));
		int result = new AdminService().articleRecovery(articleNoticeNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/adminArticleRead?articleNoticeNo=" + articleNoticeNo);
		
		if (result > 0) {
			request.setAttribute("msg", "게시글을 복구하였습니다.");
		} else {
			request.setAttribute("msg", "게시글 복구에 실패하였습니다.");
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
