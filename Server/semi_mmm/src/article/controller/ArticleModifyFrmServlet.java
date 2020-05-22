package article.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.service.ArticleNoticeService;
import article.model.vo.ArticleNotice;

/**
 * Servlet implementation class ArticleModifyFrmServlet
 */
@WebServlet(name = "ArticleModifyFrm", urlPatterns = { "/articleModifyFrm" })
public class ArticleModifyFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleModifyFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int articleNoticeNo = Integer.parseInt(request.getParameter("articleNoticeNo"));
		ArticleNotice article = new ArticleNoticeService().articleRead(articleNoticeNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/article/articleModify.jsp");
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
