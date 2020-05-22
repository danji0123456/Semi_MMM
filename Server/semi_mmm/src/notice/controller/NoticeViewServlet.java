package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog.model.vo.Dog;
import member.model.service.MemberService;
import member.model.vo.Member;
import notice.model.vo.NoticeNickname;
import notice.model.vo.noticeViewData;
import notice.service.noticeService;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet(name = "NoticeView", urlPatterns = { "/noticeView" })
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
				request.setCharacterEncoding("utf-8");
				//2. 변수에 값 저장
				
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				String memberId = request.getParameter("memberId");
				
				//3. 비지니스로직
				noticeViewData nvd = new noticeService().selectOneNotice(noticeNo);
				
				Dog dogList = new noticeService().noticeDogName(memberId);
				
				//4. 결과처리
				if(nvd.getN() != null) {
					
					request.setAttribute("n", nvd.getN());
					request.setAttribute("list", nvd.getList());
					request.setAttribute("dog", dogList);

					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/imgeNotice/imgeNoticeView.jsp");
					rd.forward(request, response);
					System.out.println("성공");
					
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
					request.setAttribute("loc", "/noticeList?reqPage=1");

					request.setAttribute("msg", "실패하셨습니다.");

					rd.forward(request, response);	
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
