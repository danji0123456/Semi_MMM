package member.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MypageMainServlet
 */
@WebServlet(name = "MypageMain", urlPatterns = { "/mypageMain" })
public class MypageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		Member m = new MemberService().selectOneMember(memberId);
		String ph1 = null;
		String ph2 = null;
		String ph3 = null;
		String[] addr = m.getAddr().split("/");
		if (m.getPhone().length() == 10) {
			ph1 = m.getPhone().substring(0,3);
			ph2 = m.getPhone().substring(3,6);
			ph3 = m.getPhone().substring(6,10);
		} else {
			ph1 = m.getPhone().substring(0,3);
			ph2 = m.getPhone().substring(3,7);
			ph3 = m.getPhone().substring(7,11);
		}
		request.setAttribute("m", m);
		request.setAttribute("ph1", ph1);
		request.setAttribute("ph2", ph2);
		request.setAttribute("ph3", ph3);
		request.setAttribute("addr",addr);
		request.getRequestDispatcher("/WEB-INF/views/member/mypageMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
