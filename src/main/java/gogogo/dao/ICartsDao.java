package gogogo.dao;



import java.util.List;
import java.util.Map;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsDao {
	/**
	 * ���빺�ﳵ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean addCarts(Carts cart);


	/**
	 * �޸Ĺ��ﳵĳ��Ʒ����
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean updateCarts(Carts cart);


	/**
	 * ��ȡĳ�û����ﳵ
	 * @param cart cartsʵ��
	 * @return List<Object>
	 */
	List<Map<String,Object>> getCart(Carts cart);


	/**
	 * ɾ��ĳ�û����ﳵĳ����Ʒ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean deleteUserCartGoods(Carts cart);

	/**
	 * ��ȡĳ�û����ﳵ��ĳ����Ʒ
	 * @param carts �û���
	 * @return map
	 */
	Map<String, Object> getGoods(Carts carts);
}
