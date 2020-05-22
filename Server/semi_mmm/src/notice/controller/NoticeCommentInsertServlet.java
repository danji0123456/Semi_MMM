package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import dog.model.service.DogService;
import dog.model.vo.Dog;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.NoticeNickname;
import notice.service.noticeService;

/**
 * Servlet implementation class NoticeCommentInsertServlet
 */
@WebServlet(name = "NoticeCommentInsert", urlPatterns = { "/noticeCommentInsert" })
public class NoticeCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
				
				
				request.setCharacterEncoding("utf-8");
				//2. 변수에 값 저장
				NoticeComment nc = new NoticeComment();
				nc.setNoticeCommentLevel(Integer.parseInt(request.getParameter("noticeCommentLevel")));
				nc.setNoticeCommentWriter(request.getParameter("noticeCommentWriter"));
				nc.setNoticeCommentContent(request.getParameter("noticeCommentContent"));
				nc.setNoticeCommentRef(Integer.parseInt(request.getParameter("noticeCommentRef")));
				nc.setNoticeCommentNo(Integer.parseInt(request.getParameter("noticeCommentNo")));
				nc.setNoticeCommentRefTwo(Integer.parseInt(request.getParameter("noticeCommentRefTwo")));
				
				

				nc.setDogId(request.getParameter("dogId"));
				System.out.println("강이지 이름 값 : "+nc.getDogId());
				System.out.println("게시글 번호 : "+nc.getNoticeCommentRef());
				System.out.println("댁글 번호 : "+nc.getNoticeCommentNo());
				System.out.println("댓글 레벨 : "+nc.getNoticeCommentLevel());
				System.out.println("작성자 : "+nc.getNoticeCommentWriter());
				
				
				//3. 비지니스 로직
				int result = new noticeService().noticeCommentInsert(nc);
				
				
				Dog dogList = new noticeService().noticeDogWrite(nc.getNoticeCommentWriter());

			
				//nc.setNoticeCommentWriter(request.getParameter("noticeCommentWriterNickname"));
				System.out.println(nc.getNoticeCommentWriter());
				//4. 결과처리
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				
				
				
				if(result>0) {
					request.setAttribute("msg", "댓글등록성공");
					request.setAttribute("nc", nc);
					request.setAttribute("dog", dogList);
					
				}else {
					request.setAttribute("msg", "댓글등록실패");
				}
				request.setAttribute("loc", "/noticeView?noticeNo="+nc.getNoticeCommentRef());
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
