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
import shop.model.vo.Cart;
import shop.model.vo.Product;
import shop.model.vo.ProductOption;
import shop.model.vo.ShopViewData;

/**
 * Servlet implementation class ToCartServlet
 */
@WebServlet(name = "ToCart", urlPatterns = { "/toCart" })
public class ToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToCartServlet() {
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
		Cart c = new Cart();
		c.setBnMemberId(request.getParameter("bnMemberId"));
		c.setOrderMemberId(request.getParameter("orderMemberId"));
		c.setSelectOpt(request.getParameter("selectOpt"));
		c.setTotalPrice(Integer.parseInt(request.getParameter("totalPrice")));
		
		//3. 비지니스로직
		int result = new ShopService().insertCart(c);
		//4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "장바구니 담기 성공");
		}else {
			request.setAttribute("msg", "장바구니 담기 실패");
		}
		request.setAttribute("loc", "/sellProductFrm2?memberId="+c.getBnMemberId());
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
