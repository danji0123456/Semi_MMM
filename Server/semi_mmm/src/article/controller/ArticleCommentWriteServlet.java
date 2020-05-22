package article.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.service.ArticleNoticeService;
import article.model.vo.ArticleNoticeComment;

/**
 * Servlet implementation class ArticleCommentWriteServlet
 */
@WebServlet(name = "ArticleCommentWrite", urlPatterns = { "/articleCommentWrite" })
public class ArticleCommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleCommentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleCommentContent = request.getParameter("articleCommentContent");
		int articleRef = Integer.parseInt(request.getParameter("articleRef"));
		String articleCommentWriter = request.getParameter("articleCommentWriter");
		int articleCommentRef = Integer.parseInt(request.getParameter("articleCommentRef"));
		int articleCommentLevel = Integer.parseInt(request.getParameter("articleCommentLevel"));
		System.out.println(articleCommentWriter);
		ArticleNoticeComment comment = new ArticleNoticeComment(0, articleCommentWriter, articleCommentContent, null, articleRef, articleCommentRef, articleCommentLevel, 0);
		
		int result = new ArticleNoticeService().articleCommentWrite(comment);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/articleRead?articleNoticeNo=" + articleRef);
		
		if (result > 0) {
			request.setAttribute("msg", "댓글을 등록하였습니다.");
		} else {
			request.setAttribute("msg", "댓글 등록에 실패하였습니다.");
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
