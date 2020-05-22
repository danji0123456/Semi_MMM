package notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog.model.vo.Dog;
import notice.model.vo.Notice;
import notice.model.vo.dogList;
import notice.service.noticeService;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet(name = "UpdateNotice", urlPatterns = { "/updateNotice" })
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String DogId = request.getParameter("dogId");
		String imgeNoticeTitle = request.getParameter("imgeNoticeTitle");
		String imgeNoticeWriter = request.getParameter("imgeNoticeWriter");
		String imgeNoticeContent = request.getParameter("content");
		int imgeNoticeNo = Integer.parseInt(request.getParameter("imgeNoticeNo"));
		int imgeNoticeViewCount = Integer.parseInt(request.getParameter("imgeNoticeViewCount"));

		String imgeNoticeImgName = "";
		Document doc = Jsoup.parse(imgeNoticeContent);
		Elements imgs = doc.getElementsByTag("img");
		if (imgs.size() > 0) {
			imgeNoticeImgName = imgs.get(0).attr("src");
			System.out.println(imgeNoticeImgName);
		}

		
		Dog dog = new noticeService().noticeDogWrite(imgeNoticeWriter);

		HttpSession session = request.getSession(false);
		
		Notice n = new Notice(imgeNoticeNo, imgeNoticeTitle, imgeNoticeWriter, imgeNoticeContent, null, imgeNoticeImgName, imgeNoticeViewCount, DogId, 0);
		if(imgeNoticeImgName.equals("")) {
			n.setNoticeImgs("/upload/dogImg/"+dog.getDogImg());
			System.out.println(n.getNoticeImgs());
		}
			
		int result = new noticeService().noticeUpdate(n);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	
		
		if (result > 0) {
			request.setAttribute("msg", " 등록되었습니다.");
			session.setAttribute("dog", dog);
			request.setAttribute("loc", "/noticeList?reqPage=1");

			
		} else {
				request.setAttribute("msg", "제목을 입력해 주세요.");
				request.setAttribute("loc", "/noticeDog?memberId="+imgeNoticeWriter);
		}
		request.setAttribute("loc", "/noticeView?noticeNo="+n.getNoticeNo());
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
