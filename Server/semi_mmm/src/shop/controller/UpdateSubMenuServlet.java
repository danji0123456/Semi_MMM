package shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.model.service.ShopService;
import shop.model.vo.ProductOption;

/**
 * Servlet implementation class UpdateSubMenuServlet
 */
@WebServlet(name = "UpdateSubMenu", urlPatterns = { "/updateSubMenu" })
public class UpdateSubMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSubMenuServlet() {
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
		ProductOption po = new ProductOption();
		po.setBnMemberId(request.getParameter("bnMemberId"));
		po.setOptionNo(Integer.parseInt(request.getParameter("optionNo")));
		po.setOptionPrice(Integer.parseInt(request.getParameter("optionPrice")));
		po.setOptionTitle(request.getParameter("optionTitle"));
		po.setProductNo(Integer.parseInt(request.getParameter("productNo")));
		
		//3. 비지니스 로직
		int result = new ShopService().updateSubMenu(po);	
		//4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "하위메뉴 수정 성공");
		}else {
			request.setAttribute("msg", "하위메뉴 수정 실패");
		}
		request.setAttribute("loc", "/myShopFrm?memberId="+po.getBnMemberId());
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
