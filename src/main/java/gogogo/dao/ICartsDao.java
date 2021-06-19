package gogogo.dao;



import java.util.List;
import java.util.Map;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsDao {
	/**
	 * 加入购物车
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean addCarts(Carts cart);


	/**
	 * 修改购物车某商品数量
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean updateCarts(Carts cart);


	/**
	 * 获取某用户购物车
	 * @param cart carts实体
	 * @return List<Object>
	 */
	List<Map<String,Object>> getCart(Carts cart);


	/**
	 * 删除某用户购物车某件商品
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean deleteUserCartGoods(Carts cart);

	/**
	 * 获取某用户购物车中某件商品
	 * @param carts 用户名
	 * @return map
	 */
	Map<String, Object> getGoods(Carts carts);
}
