package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.model.service.ArticleNoticeService;
import article.model.vo.ArticleNotice;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminArticleReadServlet
 */
@WebServlet(name = "AdminArticleRead", urlPatterns = { "/adminArticleRead" })
public class AdminArticleReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminArticleReadServlet() {
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
		ArticleNotice article = new ArticleNoticeService().articleRead(articleNoticeNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admin/adminArticleRead.jsp");
		request.setAttribute("article", article);
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
