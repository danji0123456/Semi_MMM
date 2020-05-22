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
import admin.model.vo.AdminArticleCommentList;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminArticleCommentListServlet
 */
@WebServlet(name = "AdminArticleCommentList", urlPatterns = { "/adminArticleCommentList" })
public class AdminArticleCommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminArticleCommentListServlet() {
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
		

		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		String type = request.getParameter("type");
		String search = request.getParameter("search");
		int articleRef = 0;
		AdminArticleCommentList list = null;

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admin/adminArticleCommentList.jsp");
		
		if (type == null) {
			list = new AdminService().articleCommentList(reqPage);
		} else if (type.equals("article_ref")) {
			articleRef = Integer.parseInt(search);
			list = new AdminService().articleCommentSearchList(reqPage, articleRef);
			request.setAttribute("type", type);
			request.setAttribute("search", search);
		} else {
			list = new AdminService().articleCommentSearchList(reqPage, type, search);
			request.setAttribute("type", type);
			request.setAttribute("search", search);
		}
		request.setAttribute("data", list);
		
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
