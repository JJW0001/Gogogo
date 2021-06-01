package gogogo.servlet;
/*
 * 控制获取用户信息
 */

import gogogo.service.IUserService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author 86155
 */
@WebServlet("/GetUserInfServlet")
public class GetUserInfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService service = WebUtil.getBean(IUserService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		
		//获取用户信息
		Map<String, Object> userInf = service.searchUserByName(userName);
		
		request.setAttribute("userInf", userInf);
		request.getRequestDispatcher("personalData.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
