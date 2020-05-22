package shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.model.service.ShopService;

/**
 * Servlet implementation class DeleteSubMenuServlet
 */
@WebServlet(name = "DeleteSubMenu", urlPatterns = { "/deleteSubMenu" })
public class DeleteSubMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSubMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String bnMemberId = request.getParameter("bnMemberId");
		int optionNo = Integer.parseInt(request.getParameter("optionNo"));
		int result = new ShopService().deleteSubMenu(productNo,bnMemberId,optionNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "하위 메뉴 삭제 성공");
		}else {
			request.setAttribute("msg", "하위 메뉴 삭제 실패");
		}
		request.setAttribute("loc", "/myShopFrm?memberId="+bnMemberId);
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
