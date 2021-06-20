package gogogo.dao;

import gogogo.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
public interface IGoodsDao {
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
	List<Map<String,Object>> getAllPhone();


	/**
	 * ��������Ь��
	 * @return List<Object>
	 */
	List<Map<String,Object>> getAllShoes();


	/**
	 * ����������Ʒ��Ϣ(����δ�ϼ�)
	 * @return List<Object>
	 */
	List<Map<String,Object>> getAllGoods();

	/**
	 * ͨ����Ʒ���ɾ����Ʒ
	 * @param goodsNo ��Ʒ���
	 * @return boolean
	 */
	boolean deleteGoodsById(String goodsNo);

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
	int cutStock(String goodsNo);

	/**
	 * �ӿ��
	 * @param goodsNo ��Ʒ���
	 * @param num ����
	 * @return int
	 */
	int addStock(@Param("goodsNo") String goodsNo, @Param("num") int num);
}
