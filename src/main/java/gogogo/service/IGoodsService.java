package gogogo.service;

import gogogo.bean.PageBean;
import gogogo.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
public interface IGoodsService {

	/**
	 * ��ѯ��Ʒ�Ƿ��Ѵ���
	 * @param goodsNo ��Ʒ���
	 * @return boolean
	 */
	boolean isEmpty(String goodsNo);

	/**
	 * �����Ʒ
	 * @param goods ��Ʒʵ��
	 * @return String
	 */
	String purchase(Goods goods);

	/**
	 * ����������Ʒ
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getAllGoods();

	/**
	 * ���������ֻ�
	 * @return String
	 */
	String getAllPhone();


	/**
	 * ��������Ь��
	 * @return String
	 */
	String getAllShoes();


	/**
	 * ����������Ʒ,��ҳ��ʾ
	 * @return String
	 */
	String getAllGoodsPage();


	/**
	 * ��Ʒ����
	 * @return String
	 */
	String search();

	/**
	 * ������Ʒ��Ϣ
	 * @param goods  ��Ʒʵ��
	 * @return boolean
	 */
	boolean updateGoodsInf(Goods goods);


	/**
	 * ���¼�
	 * @param goods ��Ʒʵ��
	 * @return String
	 */
	String onOffShelf(Goods goods);

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
