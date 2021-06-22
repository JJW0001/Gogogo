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
	 * 查询商品是否已存在
	 * @param goodsNo 商品编号
	 * @return boolean
	 */
	boolean isEmpty(String goodsNo);

	/**
	 * 添加商品
	 * @param goods 商品实体
	 * @return String
	 */
	String purchase(Goods goods);

	/**
	 * 查找所有商品
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getAllGoods();

	/**
	 * 查找所有手机
	 * @return String
	 */
	String getAllPhone();


	/**
	 * 查找所有鞋子
	 * @return String
	 */
	String getAllShoes();


	/**
	 * 查找所有商品,分页显示
	 * @return String
	 */
	String getAllGoodsPage();


	/**
	 * 商品搜索
	 * @return String
	 */
	String search();

	/**
	 * 更新商品信息
	 * @param goods  商品实体
	 * @return boolean
	 */
	boolean updateGoodsInf(Goods goods);


	/**
	 * 上下架
	 * @param goods 商品实体
	 * @return String
	 */
	String onOffShelf(Goods goods);

	/**
	 * 减库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	int reduceStock(String goodsNo);

	/**
	 * 加库存
	 * @param goodsNo 商品编号
	 * @param num 数量
	 * @return int
	 */
	int addStock(String goodsNo, int num);
}
