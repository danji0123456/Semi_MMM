package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/memberImg";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		String fileName = mRequest.getFilesystemName("file");
		String memberId = mRequest.getParameter("id");
		String memberPW = mRequest.getParameter("pw");
		String memberName = mRequest.getParameter("name");
		String memberNickName = mRequest.getParameter("nickname");
		String phone = (mRequest.getParameter("phone1")+mRequest.getParameter("phone2")+mRequest.getParameter("phone3"));
		String addr = (mRequest.getParameter("roadAddr")+"/"+mRequest.getParameter("jibunAddr")+"/"+mRequest.getParameter("detailAddr"));
		int level = Integer.parseInt(mRequest.getParameter("memberLevel"));
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPW);
		m.setMemberName(memberName);
		m.setMemberNickname(memberNickName);
		m.setPhone(phone);
		m.setAddr(addr);
		if (fileName != null) {
			m.setProfileImg(fileName);
		} else {
			m.setProfileImg(mRequest.getParameter("memberOriginImg"));
		}
		HttpSession session = request.getSession(false);
		if(level == 1) {
			session.setAttribute("member", m);
		} else if(level == 2) {
			session.setAttribute("shop", m);
		}
	
		
		int result = new MemberService().updateMember(m);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("msg", "정보 수정 되었습니다");
			request.setAttribute("loc", "/");
		} else {
			request.setAttribute("msg", "정보 수정 실패했습니다");
			request.setAttribute("loc", "/");
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
