package gogogo.servlet;
/*
 * 控制上架下架，通过设置goods表中的goods_state字段状态来实现商品上下架
 */

import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author 86155
 */
@WebServlet("/OnOffShelfServlet")
public class OnOffShelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String goodsNo = request.getParameter("goodsNo");
		String goodsState = request.getParameter("goodsState");
		
		Goods goods = new Goods(goodsNo, goodsState);
		
		//执行商品的上下架
		boolean check = service.onOffShelf(goods);
		//获取所有商品
		List<Object> allGoods = service.getAllGoods();
		/*
		 * 上下架提示
		 */
		String onShelf = "已上架";
		String offShelf = "已下架";
		if(goodsState.equals(onShelf)){
			request.setAttribute("GIChange", "已上架");
		}else if(goodsState.equals(offShelf)){
			request.setAttribute("GIChange", "已下架");
		}
		
		if(check){
			request.setAttribute("allGoods", allGoods);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}else{
			System.out.println("出错啦！");
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
