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
 * Servlet implementation class ArticleWriteServlet
 */
@WebServlet(name = "ArticleWrite", urlPatterns = { "/articleWrite" })
public class ArticleWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleWriteServlet() {
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
		String articleNoticeWriter = request.getParameter("articleNoticeWriter");
		String articleNoticeContent = request.getParameter("content");
		String articleNoticeImgName = "";
		Document doc = Jsoup.parse(articleNoticeContent);
		Elements imgs = doc.getElementsByTag("img");
		if (imgs.size() > 0) {
			articleNoticeImgName = imgs.get(0).attr("src");
		}
		
//		System.out.println("카테고리1 : " + articleNoticeCategory1);
//		System.out.println("카테고리2 : " + articleNoticeCategory2);
//		System.out.println("타이틀 : " + articleNoticeTitle);
//		System.out.println("작성자 : " + articleNoticeWriter);
//		System.out.println("내용 : " + articleNoticeContent);
		
		ArticleNotice article = new ArticleNotice(0, articleNoticeCategory1, articleNoticeCategory2, articleNoticeTitle, articleNoticeWriter, articleNoticeContent, null, 0, 0, articleNoticeImgName);
		int result = new ArticleNoticeService().articleWrite(article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/articleList");
		
		if (result > 0) {
			request.setAttribute("msg", "중고장터 게시물을 등록하였습니다.");
		} else {
			request.setAttribute("msg", "중고장터 게시물 등록에 실패하셨습니다.");
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
