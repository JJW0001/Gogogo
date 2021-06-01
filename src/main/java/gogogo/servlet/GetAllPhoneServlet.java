package gogogo.servlet;
/*
 * ���ƻ�ȡ�����ֻ�
 */

import gogogo.service.IGoodsService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author 86155
 */
@WebServlet("/GetAllPhoneServlet")
public class GetAllPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//�ɹ����빺�ﳵ��AddCartServlet.java�����Ĳ�����
		String tip = request.getParameter("tip");
		
		//��ȡ�����ֻ�
		ArrayList<Object> allPhone = (ArrayList<Object>)service.getAllPhone();
		
		request.setAttribute("tip", tip);
		request.setAttribute("allPhone", allPhone);
		request.getRequestDispatcher("phone.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
