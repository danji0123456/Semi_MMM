package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import shop.model.service.ShopService;
import shop.model.vo.Product;
import shop.model.vo.ProductOption;
import shop.model.vo.ShopViewData;

/**
 * Servlet implementation class MyShopFrmServlet
 */
@WebServlet(name = "MyShopFrm", urlPatterns = { "/myShopFrm" })
public class MyShopFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyShopFrmServlet() {
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
		String bnMemberId = request.getParameter("bnMemberId");
		//int productNo = Integer.parseInt(request.getParameter("productNo"));
		//3. 비지니스로직
		ArrayList<Product> list = new ShopService().selectMenuList(bnMemberId);
		//4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shop/myShopFrm.jsp");
		request.setAttribute("list", list);
		//request.setAttribute("subList", subList);
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
