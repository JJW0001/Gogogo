package gogogo.servlet;
/*
 * ���ƻ�ȡ����Ь��
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
import java.util.Map;

/**
 * @author 86155
 */
@WebServlet("/GetAllShoesServlet")
public class GetAllShoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//�ɹ����빺�ﳵ��AddCartServlet.java�����Ĳ�����
		String tip = request.getParameter("tip");
		
		//��ȡ����Ь��
		ArrayList<Map<String,Object>> allShoes = (ArrayList<Map<String,Object>>)service.getAllShoes();
		
		request.setAttribute("tip", tip);
		request.setAttribute("allShoes", allShoes);
		request.getRequestDispatcher("shoes.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
