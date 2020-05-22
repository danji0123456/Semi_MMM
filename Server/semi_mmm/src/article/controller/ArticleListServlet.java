package article.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.service.ArticleNoticeService;

/**
 * Servlet implementation class ArticleListServlet
 */
@WebServlet(name = "ArticleList", urlPatterns = { "/articleList" })
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int totalCount;

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/article/articleList.jsp");
		
		if (request.getParameter("search") == null || request.getParameter("search").equals("")) {
			totalCount = new ArticleNoticeService().getTotalCount();
		} else {
			String articleNoticeCategory1 = request.getParameter("articleNoticeCategory1");
			String articleNoticeCategory2 = request.getParameter("articleNoticeCategory2");
			String search = request.getParameter("search");
			
			totalCount = new ArticleNoticeService().getTotlaKeywordCount(articleNoticeCategory1, articleNoticeCategory2, search);
			request.setAttribute("articleNoticeCategory1", articleNoticeCategory1);
			request.setAttribute("articleNoticeCategory2", articleNoticeCategory2);
			request.setAttribute("search", search);
		}

		request.setAttribute("totalCount", totalCount);
		
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
