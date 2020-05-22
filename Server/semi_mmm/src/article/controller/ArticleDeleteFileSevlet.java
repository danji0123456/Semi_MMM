package article.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArticleDeleteFileSevlet
 */
@WebServlet(name = "ArticleDeleteFile", urlPatterns = { "/articleDeleteFile" })
public class ArticleDeleteFileSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDeleteFileSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] src = request.getParameterValues("arr[]");
		String root = getServletContext().getRealPath("/");
		for (int i = 0; i < src.length; i++) {
//			System.out.println(root + src[i].substring(1, src[i].length() - 1));
			//root와 파일의 src를 더해 해당 파일의 실제 경로를 가져와 해당 파일을 삭제한다.
			File file = new File(root + src[i].substring(1, src[i].length() - 1));
			file.delete();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
