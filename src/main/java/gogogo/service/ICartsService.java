package gogogo.service;

import java.util.List;
import java.util.Map;

import gogogo.entity.Carts;

/**
 * @author 86155
 */
public interface ICartsService {
	/**
	 * ���빺�ﳵ
	 * @param userName �û���
	 * @param goodsNo ��Ʒ���
	 * @param thisPage ��ǰҳ��
	 * @param curPage ��ҳҳ��
	 * @param search �����ؼ���
	 * @return String
	 */
	String addCart(String userName, String goodsNo, String thisPage, String curPage, String search);


	/**
	 * ��ȡĳ�û����ﳵ
	 * @param userName �û���
	 * @return String
	 */
	String getCart(String userName);


	/**
	 * ɾ��ĳ�û����ﳵĳ����Ʒ
	 * @param cart cartsʵ��
	 * @return String
	 */
	String deleteUserCartGoods(Carts cart);

	/**
	 * ��ѯĳ�û��Ƿ��Ѿ���ĳ��Ʒ���빺�ﳵ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	boolean isEmpty(Carts cart);
}
