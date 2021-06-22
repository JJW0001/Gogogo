package gogogo.service.impl;

import gogogo.dao.ICartsDao;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import gogogo.util.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Service
public class CartsServiceImpl implements ICartsService {
	private final ICartsDao icd;
	private final IGoodsDao igd;
	private final HttpServletRequest request;

	@Autowired
	public CartsServiceImpl(ICartsDao icd, IGoodsDao igd, HttpServletRequest request) {
		this.icd = icd;
		this.igd = igd;
		this.request = request;
	}

	/**
	 * 加入购物车
	 * @param userName 用户名
	 * @param goodsNo 商品编号
	 * @param thisPage 当前页面
	 * @param curPage 分页页面
     * @param search 搜索关键词
	 * @return String
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
    public String addCart(String userName, String goodsNo, String thisPage, String curPage, String search) {
		//获取当前时间对象
		Date date=new Date();
		//创建一个格式化日期对象
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String addTime = simpleDateFormat.format(date);

		/*
		 * 用户只有在登陆后userName属性才不为空，
		 * 在对应页面点击加入购物车后，AddCartServlet.java响应
		 */
		if(!"".equals(userName)){
			Carts cart = new Carts(null,userName, goodsNo, 1, addTime);

			//查询对应用户是否将对应商品加入过购物车
			boolean empty = isEmpty(cart);
			boolean check = false;

			/*
			先查询购物车中是否存在某样商品，若不存在则新加入购物车，若存在则更新数量
			*/
			Map<String, Object> goods = icd.getGoods(cart);
			try {
				if(goods == null){
					igd.cutStock(cart.getGoodsNo());
					check = icd.addCarts(cart);
				}else{
					cart.setCartsNo((int)goods.get("carts_no"));
					cart.setAddNum((int)goods.get("add_num")+1);
					igd.cutStock(cart.getGoodsNo());
					check = icd.updateCarts(cart);
				}
			}catch (Exception e){
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
					HttpSession session = request.getSession();
					int goodsNum = (int)session.getAttribute("goodsNum");
					session.setAttribute("goodsNum", goodsNum+1);
				}

				//成功加入购物车提示
				String tip = "tip";
				String phone = "phone.jsp", shoes = "shoes.jsp", allGoods = "allGoods.jsp", searchJsp = "search.jsp";
				if(phone.equals(thisPage)){
					return "GetAllPhoneServlet?tip="+tip;

				}else if(shoes.equals(thisPage)){
					return "GetAllShoesServlet?tip="+tip;

				}else if(allGoods.equals(thisPage)){
					return "GetAllGoodsServlet?curPage="+curPage+"&tip="+tip;

				}else if(searchJsp.equals(thisPage)){
					return "SearchServlet?curPage="+curPage+"&search="+search+"&tip="+tip;
				}
			}
		}else{
			return "login.jsp";
		}

		return "login.jsp";
	}


	/**
	 * 获取某用户购物车
	 * @param userName 用户名
	 * @return String
	 */
	@Override
	public String getCart(String userName) {
		if(!"".equals(userName)){
			Carts cart = new Carts(userName);
			//获取某用户的购物车信息
			List<Map<String,Object>> userCart = icd.getCart(cart);

			Iterator<Map<String,Object>> it = userCart.iterator();
			//若userCart中的元素个数为0，说明该用户购物车为空
			if(!it.hasNext()){
				HttpSession session = request.getSession();
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

			return "cart";
		}else{
			return "login";
		}
	}


	/**
	 * 删除某用户购物车某件商品
	 * @param cart carts实体
	 * @return String
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String deleteUserCartGoods(Carts cart) {
		boolean check = false;

		try {
			//执行删除操作
			Map<String, Object> goods = icd.getGoods(cart);
			igd.addStock(cart.getGoodsNo(),(int)goods.get("add_num"));
			check = icd.deleteUserCartGoods(cart);
		}catch (Exception e){
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		if (!check) {
			request.setAttribute("deleteError", "由于不可知原因删除失败！");
		}
		return "UserCartServlet";
	}


	/**
	 * 查询某用户是否已经把某商品加入购物车
	 * @param cart carts实体
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(Carts cart) {
		return icd.getGoods(cart) == null;
	}

}
