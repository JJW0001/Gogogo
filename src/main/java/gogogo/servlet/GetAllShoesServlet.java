package gogogo.servlet;
/*
 * 控制获取所有鞋子
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
		//成功加入购物车（AddCartServlet.java传来的参数）
		String tip = request.getParameter("tip");
		
		//获取所有鞋子
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
