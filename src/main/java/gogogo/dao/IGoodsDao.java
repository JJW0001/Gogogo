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
	 * 添加商品
	 * @param goods 商品实体
	 * @return boolean
	 */
	boolean purchase(Goods goods);


	/**
	 * 通过商品编号查找商品
	 * @param goodsNo 商品编号
	 * @return Map<String, Object>
	 */
	Map<String, Object> searchGoodsById(String goodsNo);


	/**
	 * 修改商品信息
	 * @param goods 商品实体
	 * @return boolean
	 */
	boolean updateGoodsInf(Goods goods);


	/**
	 * 查找所有手机
	 * @return List<Object>
	 */
	List<Map<String,Object>> getAllPhone();


	/**
	 * 查找所有鞋类
	 * @return List<Object>
	 */
	List<Map<String,Object>> getAllShoes();


	/**
	 * 查找所有商品信息(包括未上架)
	 * @return List<Object>
	 */
	List<Map<String,Object>> getAllGoods();

	/**
	 * 通过商品编号删除商品
	 * @param goodsNo 商品编号
	 * @return boolean
	 */
	boolean deleteGoodsById(String goodsNo);

	/**
	 * 上下架
	 * @param goods 商品实体
	 * @return int
	 */
	int onOffShelf(Goods goods);

	/**
	 * 减库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	int cutStock(String goodsNo);

	/**
	 * 加库存
	 * @param goodsNo 商品编号
	 * @param num 数量
	 * @return int
	 */
	int addStock(@Param("goodsNo") String goodsNo, @Param("num") int num);
}
