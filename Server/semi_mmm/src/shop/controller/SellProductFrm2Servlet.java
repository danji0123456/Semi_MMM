package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.model.service.ShopService;
import shop.model.vo.Product;
import shop.model.vo.ShopViewData;

/**
 * Servlet implementation class SellProductFrm2Servlet
 */
@WebServlet(name = "SellProductFrm2", urlPatterns = { "/sellProductFrm2" })
public class SellProductFrm2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellProductFrm2Servlet() {
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
		String bnMemberId = request.getParameter("memberId");
		String memberNickname = request.getParameter("memberNickname");
		//3. 비지니스로직
		//ArrayList<Product> pl = new ShopService().selectMenuList(bnMemberId);
		ArrayList<ShopViewData> sl = new ShopService().selectMenuListFrm(bnMemberId);
		//4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shop/sellProductFrm.jsp");
		request.setAttribute("loc", "/sellProductFrm?memberId="+bnMemberId);
		request.setAttribute("sl", sl);
		request.setAttribute("bnMemberId", bnMemberId);
		request.setAttribute("memberNickname", memberNickname);
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
