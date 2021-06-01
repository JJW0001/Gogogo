package gogogo.servlet;
/*
 * ���Ƶ�¼
 */

import gogogo.entity.Carts;
import gogogo.entity.User;
import gogogo.service.ICartsService;
import gogogo.service.IUserService;
import gogogo.util.Calculation;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Servlet implementation class LoginServlet
 * @author 86155
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService service = WebUtil.getBean(IUserService.class);
	ICartsService service1 = WebUtil.getBean(ICartsService.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		User user = new User(userName,userPwd);
		
		//��¼�ɹ�����true
		if(service.login(user)){
			//��ȡĳ�û���Ϣ
			Map<String, Object> userInf = service.searchUserByName(userName);
			//�õ��û�ͷ��
			String userHead = (String)userInf.get("user_head");
			
			Carts cart = new Carts(userName);
			//��ȡĳ�û����ﳵ��Ϣ
			ArrayList<Object> userCart = (ArrayList<Object>)service1.getCart(cart);
			//�õ�ĳ�û����ﳵ�в�ͬ��Ʒ����
			int goodsNum = Calculation.getGoodsNum(userCart);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("userHead", userHead);
			session.setAttribute("userName", userName);
			session.setAttribute("goodsNum", goodsNum);
			session.setMaxInactiveInterval(1800);
			
			response.sendRedirect("index.jsp");
			return;
		}else{
			request.setAttribute("alert", "��¼ʧ�ܣ��û����������������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
