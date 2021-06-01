package gogogo.dao;



import java.util.List;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsDao {
	/**
	 * ��ѯ���ﳵ���Ƿ���ĳ����Ʒ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean isEmpty(Carts cart);


	/**
	 * ���빺�ﳵ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean addCarts(Carts cart);


	/**
	 * �޸��̹��ﳵ��Ϣ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean updateCarts(Carts cart);


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
	 * ��ȡĳ�û����빺�ﳵ��ĳ����Ʒ���������
	 * @param userName �û���
	 * @param goodsNo ��Ʒ���
	 * @return Object[]
	 */
	Object[] getGoodsNum(String userName, String goodsNo);
	
}
