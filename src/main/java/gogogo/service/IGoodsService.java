package gogogo.service;

import gogogo.bean.PageBean;
import gogogo.entity.Goods;

import java.util.List;

/**
 * @author 86155
 */
public interface IGoodsService {

	/**
	 * �����Ʒ
	 * @param goods ��Ʒʵ��
	 * @return boolean
	 */
	boolean purchase(Goods goods);

	/**
	 * ����������Ʒ
	 * @return List<Object>
	 */
	List<Object> getAllGoods();

	/**
	 * ���������ֻ�
	 * @return List<Object>
	 */
	List<Object> getAllPhone();


	/**
	 * ����������Ʒ
	 * @return List<Object>
	 */
	List<Object> getAllShoes();


	/**
	 * ����������Ʒ,��ҳ��ʾ
	 * @param curPage ��ǰҳ��
	 * @return PageBean
	 */
	PageBean getAllGoods(int curPage);


	/**
	 * ��Ʒ����
	 * @param parameter �����ؼ���
	 * @param curPage  ��ǰҳ��
	 * @return PageBean
	 */
	PageBean search(String parameter, int curPage);

	/**
	 * ������Ʒ��Ϣ
	 * @param goods  ��Ʒʵ��
	 * @return boolean
	 */
	boolean updateGoodsInf(Goods goods);


	/**
	 * ���¼�
	 * @param goods ��Ʒʵ��
	 * @return boolean
	 */
	boolean onOffShelf(Goods goods);

	/**
	 * �����
	 * @param goodsNo ��Ʒ���
	 * @return int
	 */
	int reduceStock(String goodsNo);

	/**
	 * �ӿ��
	 * @param goodsNo ��Ʒ���
	 * @param num ����
	 * @return int
	 */
	int addStock(String goodsNo, int num);
}
