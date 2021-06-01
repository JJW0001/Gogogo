package gogogo.dao;

import gogogo.bean.PageBean;
import gogogo.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
public interface IGoodsDao {
	/**
	 * ��ѯ��Ʒ�Ƿ��Ѵ���
	 * @param goodsNo ��Ʒ���
	 * @return boolean
	 */
	boolean isEmpty(String goodsNo);


	/**
	 * �����Ʒ
	 * @param goods ��Ʒʵ��
	 * @return boolean
	 */
	boolean purchase(Goods goods);


	/**
	 * ͨ����Ʒ��Ų�����Ʒ
	 * @param goodsNo ��Ʒ���
	 * @return Map<String, Object>
	 */
	Map<String, Object> searchGoodsById(String goodsNo);


	/**
	 * �޸���Ʒ��Ϣ
	 * @param goods ��Ʒʵ��
	 * @return boolean
	 */
	boolean updateGoodsInf(Goods goods);


	/**
	 * ���������ֻ�
	 * @return List<Object>
	 */
	List<Object> getAllPhone();


	/**
	 * ��������Ь��
	 * @return List<Object>
	 */
	List<Object> getAllShoes();


	/**
	 * ����������Ʒ��Ϣ
	 * @return List<Object>
	 */
	List<Object> getAllGoods();


	/**
	 * ����������Ʒ,��ҳ��ʾ
	 * @param curPage ��ǰ����ҳ��
	 * @return PageBean
	 */
	PageBean getAllGoods(int curPage);


	/**
	 * ͨ����Ʒ���ɾ����Ʒ
	 * @param goodsNo ��Ʒ���
	 * @return boolean
	 */
	boolean deleteGoodsById(String goodsNo);


	/**
	 * ������Ʒ
	 * @param parameter �����ؼ���
	 * @param curPage ��ǰ����ҳ��
	 * @return PageBean
	 */
	PageBean search(String parameter, int curPage);

	/**
	 * ���¼�
	 * @param goods ��Ʒʵ��
	 * @return int
	 */
	int onOffShelf(Goods goods);

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
