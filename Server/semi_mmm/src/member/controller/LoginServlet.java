package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member m = new MemberService().selectOneMember(memberId, memberPw);
		if (m != null) {
			if (m.getMemberLevel() == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("member", m);
				response.getWriter().print(3);
			} else if (m.getMemberLevel() == 2) {
				HttpSession session = request.getSession();
				session.setAttribute("shop", m);
				response.getWriter().print(3);
			} else if(m.getMemberLevel() == 3 || m.getMemberLevel() == 4) {
				response.setContentType("applicaion/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(2);
			} else if(m.getMemberLevel() == 0) {
				response.setContentType("applicaion/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(0);
				HttpSession session = request.getSession();
				session.setAttribute("member", m);
			}
			else {
				response.setContentType("applicaion/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(1);
			}
		} else {
			response.setContentType("applicaion/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(1);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
