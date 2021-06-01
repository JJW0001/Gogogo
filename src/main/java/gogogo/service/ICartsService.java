package gogogo.service;

import java.util.List;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsService {
	/**
	 * 加入购物车
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean addCart(Carts cart);


	/**
	 * 获取某用户购物车
	 * @param cart carts实体
	 * @return List<Object>
	 */
	List<Object> getCart(Carts cart);


	/**
	 * 删除某用户购物车某件商品
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean deleteUserCartGoods(Carts cart);

	/**
	 * 查询某用户是否已经把某商品加入购物车
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean isEmpty(Carts cart);
}
