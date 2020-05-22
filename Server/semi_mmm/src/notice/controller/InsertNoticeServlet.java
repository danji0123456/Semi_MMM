package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Generated;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import dog.model.vo.Dog;
import notice.model.vo.Notice;
import notice.service.noticeService;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet(name = "InsertNotice", urlPatterns = { "/insertNotice" })
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String DogName = request.getParameter("dogName");
		
		System.out.println("강아지 이름 : "+DogName);
		String imgeNoticeTitle = request.getParameter("imgeNoticeTitle");
		String imgeNoticeWriter = request.getParameter("imgeNoticeWriter");
		String imgeNoticeContent = request.getParameter("content");
		
		String imgeNoticeImgName = "";
		Document doc = Jsoup.parse(imgeNoticeContent);
		Elements imgs = doc.getElementsByTag("img");
		if (imgs.size() > 0) {
			imgeNoticeImgName = imgs.get(0).attr("src");
			System.out.println(imgeNoticeImgName);
		}
		
		
		Dog dog = new noticeService().noticeDogWrite(imgeNoticeWriter);
		//NoticeImg ni = new NoticeImg();
		//ni.setNoticeImg(imgeNoticeImgName);
		//ni.setDogImg(dog.getDogImg());

		
		

		System.out.println("값확인 : "+imgeNoticeTitle);
		System.out.println("값확인 : "+imgeNoticeWriter);
		System.out.println("값확인 : "+imgeNoticeContent);
		System.out.println("값확인 : "+imgeNoticeImgName);
		System.out.println("값확인 : "+dog.getDogImg());


		Notice n = new Notice(0, imgeNoticeTitle, imgeNoticeWriter, imgeNoticeContent, null, imgeNoticeImgName, 0, dog.getDogId(), 0);
		if(imgeNoticeImgName.equals("")) {
			n.setNoticeImgs("/upload/dogImg/"+dog.getDogImg());
			System.out.println("중간 확인 : "+n.getNoticeImgs());
		}
		if(n.getNoticeImgs().equals("/upload/dogImg/")) {
			System.out.println("중간 확인2 : "+n.getNoticeImgs());
			n.setNoticeImgs("/upload/memberImg/unnamed.png");
		}

		int result = new noticeService().noticeWrite(n);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		

		
		if (result > 0) {
			request.setAttribute("msg", " 등록되었습니다.");
			request.setAttribute("dogName", DogName);
			request.setAttribute("loc", "/noticeList?reqPage=1");
			System.out.println("강아지 이름 : "+DogName);
			
		} else {
				request.setAttribute("msg", "제목을 입력해 주세요.");
				request.setAttribute("loc", "/noticeDog?memberId="+imgeNoticeWriter);
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
