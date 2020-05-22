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
 * Servlet implementation class UpdateDogServlet
 */
@WebServlet(name = "UpdateDog", urlPatterns = { "/updateDog" })
public class UpdateDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDogServlet() {
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
		String dogId = mRequest.getParameter("dogId");
		String fileName = mRequest.getFilesystemName("dogImg");
		Dog dog = new Dog();
		dog.setDogName(mRequest.getParameter("dogName"));
		dog.setVariety(mRequest.getParameter("dogCate") + "/" + mRequest.getParameter("variety"));
		dog.setAge(Integer.parseInt(mRequest.getParameter("dogAge")));
		dog.setDogGender(mRequest.getParameter("dogGender"));
		if (fileName!=null) {
			dog.setDogImg(mRequest.getFilesystemName("dogImg"));
		} else {
			dog.setDogImg(mRequest.getParameter("dogOriginImg"));
		}
		int result = new DogService().updateDog(dogId, dog);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/popupmsg.jsp");
		if (result > 0) {
			request.setAttribute("msg", "정보수정 완료");
		} else {
			request.setAttribute("msg", "정보수정 실패");
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
