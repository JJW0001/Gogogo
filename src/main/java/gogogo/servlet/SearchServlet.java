package gogogo.servlet;
/*
 * 控制搜索商品
 */

import gogogo.bean.PageBean;
import gogogo.service.IGoodsService;
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
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tip = request.getParameter("tip");
		String param1 = request.getParameter("search");
		String curPage1 = request.getParameter("curPage");
		
		String parameter = "%iphone%";
		if(!"".equals(param1)){
			parameter = "%" + param1 + "%";
		}
		
		int curPage2 = 1;
		if(curPage1!=null){
			curPage2 = Integer.parseInt(curPage1);
		}
		
		//获取所有商品，分页显示
		PageBean goods = service.search(parameter, curPage2);
		
		request.setAttribute("tip", tip);
		request.setAttribute("goods", goods);
		request.setAttribute("param", param1);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
