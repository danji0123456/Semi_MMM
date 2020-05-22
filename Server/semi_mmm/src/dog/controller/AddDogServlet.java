package dog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog.model.service.DogService;
import dog.model.vo.Dog;

/**
 * Servlet implementation class AddDogServlet
 */
@WebServlet(name = "AddDog", urlPatterns = { "/addDog" })
public class AddDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/dogImg";
		int maxSize = 10*1024*1024;		
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		String memberId = mRequest.getParameter("memberId");
		String dogImg = mRequest.getFilesystemName("dogImg");
		if (dogImg == null) {
			dogImg = "noDogImg.png";
		} 
		Dog dog = new Dog();
		dog.setDogId(mRequest.getParameter("dogId"));
		dog.setDogMemberId(memberId);
		dog.setDogName(mRequest.getParameter("dogName"));
		dog.setVariety(mRequest.getParameter("dogCate") + "/" + mRequest.getParameter("variety"));
		dog.setAge(Integer.parseInt(mRequest.getParameter("dogAge")));
		dog.setDogGender(mRequest.getParameter("dogGender"));
		dog.setDogImg(dogImg);
		dog.setDogBool(0);
		int result = new DogService().insertDog(dog);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("msg", "등록 완료");
			request.setAttribute("loc", "/myDog?memberId="+memberId+"");
		} else {
			request.setAttribute("msg", "등록 실패");
			request.setAttribute("loc", "/myDog?memberId="+memberId+"");
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
