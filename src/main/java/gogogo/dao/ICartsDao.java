package gogogo.dao;



import java.util.List;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsDao {
	/**
	 * 查询购物车中是否有某件商品
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean isEmpty(Carts cart);


	/**
	 * 加入购物车
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean addCarts(Carts cart);


	/**
	 * 修改商购物车信息
	 * @param cart carts实体
	 * @return boolean
	 */
	boolean updateCarts(Carts cart);


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
	 * 获取某用户加入购物车的某样商品数量和序号
	 * @param userName 用户名
	 * @param goodsNo 商品编号
	 * @return Object[]
	 */
	Object[] getGoodsNum(String userName, String goodsNo);
	
}
