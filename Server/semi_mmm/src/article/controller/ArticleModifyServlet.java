package article.controller;

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

import article.model.service.ArticleNoticeService;
import article.model.vo.ArticleNotice;

/**
 * Servlet implementation class ArticleModifyServlet
 */
@WebServlet(name = "ArticleModify", urlPatterns = { "/articleModify" })
public class ArticleModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleNoticeCategory1 = request.getParameter("articleNoticeCategory1");
		String articleNoticeCategory2 = request.getParameter("articleNoticeCategory2");
		String articleNoticeTitle = request.getParameter("title");
		int articleNoticeNo = Integer.parseInt(request.getParameter("articleNoticeNo"));
		String articleNoticeContent = request.getParameter("content");
		int articleNoticeSoldBool; 
		if (request.getParameter("articleNoticeSoldBool") == null) {
			articleNoticeSoldBool = 1;
		} else {
			articleNoticeSoldBool = 0;
		}
		
		String articleNoticeImgName = "";
		Document doc = Jsoup.parse(articleNoticeContent);
		Elements imgs = doc.getElementsByTag("img");
		
		if (imgs.size() > 0) {
			articleNoticeImgName = imgs.get(0).attr("src");
		}
		
		ArticleNotice article = new ArticleNotice(articleNoticeNo, articleNoticeCategory1, articleNoticeCategory2, articleNoticeTitle, null, articleNoticeContent, null, articleNoticeSoldBool, 0, articleNoticeImgName);
		int result = new ArticleNoticeService().articleModify(article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/articleRead?articleNoticeNo=" + articleNoticeNo);
		
		if (result > 0) {
			request.setAttribute("msg", "게시물을 수정하였습니다.");
		} else {
			request.setAttribute("msg", "게시물을 수정하는데 실패하였습니다.");
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
