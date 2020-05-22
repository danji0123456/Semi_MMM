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
 * Servlet implementation class ArticleCommentModifyServlet
 */
@WebServlet(name = "ArticleCommentModify", urlPatterns = { "/articleCommentModify" })
public class ArticleCommentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleCommentModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleCommentContent = request.getParameter("articleCommentContent");
		int articleCommentNo = Integer.parseInt(request.getParameter("articleCommentNo"));
		int articleNoticeNo = Integer.parseInt(request.getParameter("articleNoticeNo"));
		
		int result = new ArticleNoticeService().articleCommentModify(articleCommentContent, articleCommentNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/articleRead?articleNoticeNo=" + articleNoticeNo);
		
		if (result > 0) {
			request.setAttribute("msg", "댓글을 수정하였습니다.");
		} else {
			request.setAttribute("msg", "댓글 수정에 실패하셨습니다.");
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
