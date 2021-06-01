package gogogo.service;

import java.util.List;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsService {
	/**
	 * ���빺�ﳵ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean addCart(Carts cart);


	/**
	 * ��ȡĳ�û����ﳵ
	 * @param cart cartsʵ��
	 * @return List<Object>
	 */
	List<Object> getCart(Carts cart);


	/**
	 * ɾ��ĳ�û����ﳵĳ����Ʒ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean deleteUserCartGoods(Carts cart);

	/**
	 * ��ѯĳ�û��Ƿ��Ѿ���ĳ��Ʒ���빺�ﳵ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean isEmpty(Carts cart);
}
