package article.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import article.model.service.ArticleNoticeService;
import article.model.vo.ArticleNotice;

/**
 * Servlet implementation class ArticleMoreServlet
 */
@WebServlet(name = "ArticleMore", urlPatterns = { "/articleMore" })
public class ArticleMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleMoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int start = Integer.parseInt(request.getParameter("start"));
		String articleNoticeCategory1 = request.getParameter("articleNoticeCategory1");
		String articleNoticeCategory2 = request.getParameter("articleNoticeCategory2");
		String search = request.getParameter("search");
		
		ArrayList<ArticleNotice> list = null;
		
		if (search == null || search.equals("")) {
			list = new ArticleNoticeService().articleMore(start);	
		} else {
			list = new ArticleNoticeService().articleKeywordMore(start, articleNoticeCategory1, articleNoticeCategory2, search);
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
