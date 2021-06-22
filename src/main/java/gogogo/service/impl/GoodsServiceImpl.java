package gogogo.service.impl;

import gogogo.bean.PageBean;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import gogogo.util.GetPageInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
	
	private final IGoodsDao igd;
	private final GetPageInf gpi;
	private final HttpServletRequest request;

	@Autowired
	public GoodsServiceImpl(IGoodsDao igd, GetPageInf gpi, HttpServletRequest request) {
		this.igd = igd;
		this.gpi = gpi;
		this.request = request;
	}

	/**
	 * 查询商品是否已存在
	 * @param goodsNo 商品编号
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String goodsNo){
		return igd.searchGoodsById(goodsNo) == null;
	}

	/**
	 * 上架
	 * @param goods 商品实体
	 * @return String
	 */
	@Override
	public String purchase(Goods goods){
		if(isEmpty(goods.getGoodsNo())) {
			igd.purchase(goods);
		}
		return "index";
	}


	/**
	 * 查找所有商品
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getAllGoods(){
		return igd.getAllGoods();
	}


	/**
	 * 查找所有商品,分页显示
	 * @return String
	 */
	@Override
	public String getAllGoodsPage(){
		//获取要跳转到的页
		String curPage1 = request.getParameter("curPage");
		//成功加入购物车（AddCartServlet.java传来的参数）
		String tip = request.getParameter("tip");

		int curPage2 = 1;
		if(curPage1!=null){
			curPage2 = Integer.parseInt(curPage1);
		}

		//获取所有商品，分页显示
		String sql = "select * from goods order by goods_stock";
		PageBean allGoods = gpi.getPageBean(sql, null, curPage2);

		request.setAttribute("tip", tip);
		request.setAttribute("allGoods", allGoods);

		return "allGoods";
	}


	/**
	 * 查找所有手机
	 * @return String
	 */
	@Override
	public String getAllPhone(){
		//成功加入购物车（AddCartServlet.java传来的参数）
		String tip = request.getParameter("tip");

		//获取所有手机
		ArrayList<Map<String,Object>> allPhone = (ArrayList<Map<String,Object>>)igd.getAllPhone();

		request.setAttribute("tip", tip);
		request.setAttribute("allPhone", allPhone);

		return "phone";
	}


	/**
	 * 查找所有鞋类
	 * @return String
	 */
	@Override
	public String getAllShoes(){
		//成功加入购物车（AddCartServlet.java传来的参数）
		String tip = request.getParameter("tip");

		//获取所有鞋子
		ArrayList<Map<String,Object>> allShoes = (ArrayList<Map<String,Object>>)igd.getAllShoes();

		request.setAttribute("tip", tip);
		request.setAttribute("allShoes", allShoes);

		return "shoes";
	}


	/**
	 * 搜索商品
	 * @return String
	 */
	@Override
	public String search() {
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

		String sql = "select * from goods where goods_desc like ?";
		Object[] params = {parameter};
		PageBean goods = gpi.getPageBean(sql, params, curPage2);

		request.setAttribute("tip", tip);
		request.setAttribute("goods", goods);
		request.setAttribute("param", param1);

		return "search";
	}


	/**
	 * 修改商品信息
	 * @param goods  商品实体
	 * @return boolean
	 */
	@Override
	public boolean updateGoodsInf(Goods goods) {
		return igd.updateGoodsInf(goods);
	}


	/**
	 * 上下架
	 * @param goods 商品实体
	 * @return String
	 */
	@Override
	public String onOffShelf(Goods goods){
		//执行商品的上下架
		boolean check = igd.onOffShelf(goods);
		//获取所有商品
		List<Map<String,Object>> allGoods = igd.getAllGoods();
		request.setAttribute("allGoods", allGoods);

		if(check){
			/*
			 * 上下架提示
			 */
			String onShelf = "已上架";
			String offShelf = "已下架";
			if(goods.getGoodsState().equals(onShelf)){
				request.setAttribute("GIChange", "已上架");
			}else if(goods.getGoodsState().equals(offShelf)){
				request.setAttribute("GIChange", "已下架");
			}
		}else{
			request.setAttribute("GIChange", "出错啦");
		}

		return "admin";
	}

	/**
	 * 减库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	@Override
	public int reduceStock(String goodsNo) {
		return igd.cutStock(goodsNo);
	}

	/**
	 * 加库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	@Override
	public int addStock(String goodsNo, int num) {
		return igd.addStock(goodsNo, num);
	}
}
