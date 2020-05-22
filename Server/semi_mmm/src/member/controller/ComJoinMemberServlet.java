package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.Shop;

/**
 * Servlet implementation class JoinMemberServlet
 */
@WebServlet(name = "ComJoinMember", urlPatterns = { "/comJoinMember" })
public class ComJoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComJoinMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("birth");
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
	    SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
	    java.util.Date tempDate = null;
	    try {
			tempDate = beforeFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String transDate = afterFormat.format(tempDate);
	    Date d = Date.valueOf(transDate);

		Member m = new Member();
		m.setMemberId(request.getParameter("id"));
		m.setMemberPw(request.getParameter("password"));
		m.setMemberName(request.getParameter("name"));
		m.setMemberNickname(request.getParameter("nickname"));
		m.setMemberBirth(d);
		m.setPhone(request.getParameter("phone1")+request.getParameter("phone3")+request.getParameter("phone2"));
		m.setAddr(request.getParameter("roadAddr")+"/"+request.getParameter("jibunAddr")+"/"+request.getParameter("detailAddr"));
		m.setMemberLevel(2);
		m.setProfileImg(null);
		new MemberService().insertMember(m);
		Shop shop = new Shop();
		shop.setShopId(request.getParameter("shopId"));
		shop.setShopMemberId(request.getParameter("id"));
		shop.setShopBank(request.getParameter("shopBank"));
		shop.setShopBankAccount(request.getParameter("shopBankAccount"));
		new MemberService().insertShop(shop);
		request.getRequestDispatcher("/WEB-INF/views/member/joinFinish.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
