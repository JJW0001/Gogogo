package gogogo.servlet;
/*
 * ���ƻ�ȡĳ�û��Ĺ��ﳵ��Ϣ
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
			//��ȡĳ�û��Ĺ��ﳵ��Ϣ
			List<Map<String,Object>> userCart = service.getCart(cart);
			
			Iterator<Map<String,Object>> it = userCart.iterator();
			//��userCart�е�Ԫ�ظ���Ϊ0��˵�����û����ﳵΪ��
			if(!it.hasNext()){
				HttpSession session = request.getSession(true);
				//���ﳵ�в�ͬ��Ʒ����Ϊ0
				session.setAttribute("goodsNum", 0);
				//����request��Χ����Ч��cartEmpty���ԣ�����ֵΪcartEmpty����ʾ���ﳵΪ��
				request.setAttribute("cartEmpty", "cartEmpty");
			}else{
				//�ܼ�
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
