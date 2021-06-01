package gogogo.service;

import gogogo.bean.PageBean;
import gogogo.entity.Goods;

import java.util.List;

/**
 * @author 86155
 */
public interface IGoodsService {

	/**
	 * 添加商品
	 * @param goods 商品实体
	 * @return boolean
	 */
	boolean purchase(Goods goods);

	/**
	 * 查找所有商品
	 * @return List<Object>
	 */
	List<Object> getAllGoods();

	/**
	 * 查找所有手机
	 * @return List<Object>
	 */
	List<Object> getAllPhone();


	/**
	 * 查找所有商品
	 * @return List<Object>
	 */
	List<Object> getAllShoes();


	/**
	 * 查找所有商品,分页显示
	 * @param curPage 当前页数
	 * @return PageBean
	 */
	PageBean getAllGoods(int curPage);


	/**
	 * 商品搜索
	 * @param parameter 搜索关键字
	 * @param curPage  当前页数
	 * @return PageBean
	 */
	PageBean search(String parameter, int curPage);

	/**
	 * 更新商品信息
	 * @param goods  商品实体
	 * @return boolean
	 */
	boolean updateGoodsInf(Goods goods);


	/**
	 * 上下架
	 * @param goods 商品实体
	 * @return boolean
	 */
	boolean onOffShelf(Goods goods);

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
