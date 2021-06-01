package gogogo.servlet;
/*
 * 控制管理商品
 */

import gogogo.service.IGoodsService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 86155
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Object> allGoods = service.getAllGoods();
		
		HttpSession  session = request.getSession(true);
		String userName = (String)session.getAttribute("userName");
		String managerName = "韦俊锦";
		if(userName.equals(managerName)){
			request.setAttribute("allGoods", allGoods);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}else{
			request.setAttribute("admin", "对不起，您不是管理员");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
