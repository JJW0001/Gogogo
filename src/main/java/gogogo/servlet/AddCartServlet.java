package gogogo.servlet;
/*
 * 控制加入购物车
 */

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import gogogo.util.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 86155
 */
@WebServlet("/AddCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ICartsService service = WebUtil.getBean(ICartsService.class);

    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取当前时间对象
		Date date=new Date();
		//创建一个格式化日期对象
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String goodsNo = request.getParameter("goodsNo");
		String addTime = simpleDateFormat.format(date);

		/*
		 * 用户只有在登陆后userName属性才不为空，
		 * 在对应页面点击加入购物车后，AddCartServlet.java响应
		 */
		if(!"".equals(userName)){
			Carts cart = new Carts(null,userName, goodsNo, 1, addTime);


			//查询对应用户是否将对应商品加入过购物车
			boolean empty = service.isEmpty(cart);
			boolean check = false;
			try {
				check = service.addCart(cart);
			}catch (ArithmeticException e){
				e.printStackTrace();
			}
			/*
			 * 成功加入购物车后check值为true，再判断empty的值，empty值为true说明某商品加入过购物车，
			 * 此时将goodsNum（某用户购物车中不同商品的数量）的值加1
			 * 如果empty值为false说明某商品未加入过购物车，则不将goodsNum的值加1
			 * 
			 * 根据在不同页面点击加入购物车，thisPage的值将会不同，判断thisPage的值在跳转到不同的servlet以获取商品数据
			 */
			if(check){
				if(empty){
					HttpSession session = request.getSession(true);
					int goodsNum = (int)session.getAttribute("goodsNum");
					session.setAttribute("goodsNum", goodsNum+1);
				}

				//成功加入购物车提示
				String tip = "tip";
				String phone = "phone.jsp", shoes = "shoes.jsp", allGoods = "allGoods.jsp", searchJsp = "search.jsp";
				String thisPage = "thisPage";
				if(phone.equals(request.getParameter(thisPage))){
					response.sendRedirect("GetAllPhoneServlet?tip="+tip);
					return;
					
					
				}else if(shoes.equals(request.getParameter(thisPage))){
					response.sendRedirect("GetAllShoesServlet?tip="+tip);
					return;
					
					
				}else if(allGoods.equals(request.getParameter(thisPage))){
					String curPage = request.getParameter("curPage");
					response.sendRedirect("GetAllGoodsServlet?curPage="+curPage+"&tip="+tip);
					return;
					
					
				}else if(searchJsp.equals(request.getParameter(thisPage))){
					String curPage = request.getParameter("curPage");
					String search = request.getParameter("search");
					response.sendRedirect("SearchServlet?curPage="+curPage+"&search="+search+"&tip="+tip);
					return;
				}
			}
		}else{
			response.sendRedirect("login.jsp");
			return;
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}

}
