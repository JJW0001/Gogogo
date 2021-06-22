package gogogo.service;

import java.util.List;
import java.util.Map;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsService {
	/**
	 * 加入购物车
	 * @param userName 用户名
	 * @param goodsNo 商品编号
	 * @param thisPage 当前页面
	 * @param curPage 分页页面
	 * @param search 搜索关键词
	 * @return String
	 */
	String addCart(String userName, String goodsNo, String thisPage, String curPage, String search);


	/**
	 * 获取某用户购物车
	 * @param userName 用户名
	 * @return String
	 */
	String getCart(String userName);


	/**
	 * 删除某用户购物车某件商品
	 * @param cart carts实体
	 * @return String
	 */
	String deleteUserCartGoods(Carts cart);

	/**
	 * 查询某用户是否已经把某商品加入购物车
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean isEmpty(Carts cart);
}
