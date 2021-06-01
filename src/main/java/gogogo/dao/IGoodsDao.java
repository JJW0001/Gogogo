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
	 * 查询商品是否已存在
	 * @param goodsNo 商品编号
	 * @return boolean
	 */
	boolean isEmpty(String goodsNo);


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
	List<Object> getAllPhone();


	/**
	 * 查找所有鞋类
	 * @return List<Object>
	 */
	List<Object> getAllShoes();


	/**
	 * 查找所有商品信息
	 * @return List<Object>
	 */
	List<Object> getAllGoods();


	/**
	 * 查找所有商品,分页显示
	 * @param curPage 当前所在页数
	 * @return PageBean
	 */
	PageBean getAllGoods(int curPage);


	/**
	 * 通过商品编号删除商品
	 * @param goodsNo 商品编号
	 * @return boolean
	 */
	boolean deleteGoodsById(String goodsNo);


	/**
	 * 搜索商品
	 * @param parameter 搜索关键字
	 * @param curPage 当前所在页数
	 * @return PageBean
	 */
	PageBean search(String parameter, int curPage);

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
	int reduceStock(String goodsNo);

	/**
	 * 加库存
	 * @param goodsNo 商品编号
	 * @param num 数量
	 * @return int
	 */
	int addStock(String goodsNo, int num);
}
