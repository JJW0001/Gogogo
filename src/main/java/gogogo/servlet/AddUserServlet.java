package gogogo.servlet;
/*
 * 控制用户注册
 */

import gogogo.entity.User;
import gogogo.service.IUserService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 86155
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService service = WebUtil.getBean(IUserService.class);
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userTel = request.getParameter("userTel");
		String userEmail = request.getParameter("userEmail");
		User user = new User(userName, userPwd, userTel, userEmail,"images/head.jpg");
		
		//添加新用户到数据库
		boolean check = service.addUser(user);
		if(check){
			request.setAttribute("alert", "注册成功，请登录确认！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{
			request.setAttribute("alert", "注册失败，该用户名已被注册！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}	

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
