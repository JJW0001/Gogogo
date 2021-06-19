package gogogo.servlet;
/*
 * 控制获取某用户的购物车信息
 */

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import gogogo.util.Calculation;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author 86155
 */
@WebServlet("/UserCartServlet")
public class UserCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ICartsService service = WebUtil.getBean(ICartsService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		
		if(!"".equals(userName)){
			Carts cart = new Carts(userName);
			//获取某用户的购物车信息
			List<Map<String,Object>> userCart = service.getCart(cart);
			
			Iterator<Map<String,Object>> it = userCart.iterator();
			//若userCart中的元素个数为0，说明该用户购物车为空
			if(!it.hasNext()){
				HttpSession session = request.getSession(true);
				//购物车中不同商品数量为0
				session.setAttribute("goodsNum", 0);
				//设置request范围内有效的cartEmpty属性，属性值为cartEmpty，提示购物车为空
				request.setAttribute("cartEmpty", "cartEmpty");
			}else{
				//总价
				float totalPrice = Calculation.getTotalPrice(userCart);
				int goodsNum = Calculation.getGoodsNum(userCart);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("goodsNum", goodsNum);
				
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("userCart", userCart);
			}
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
