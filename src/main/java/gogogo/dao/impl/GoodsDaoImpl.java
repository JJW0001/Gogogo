package gogogo.dao.impl;

import gogogo.bean.PageBean;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Goods;
import gogogo.util.GetPageInf;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@SuppressWarnings("all")
@Repository
public class GoodsDaoImpl extends BaseDao implements IGoodsDao {
	private GetPageInf getPageInf;

	public GoodsDaoImpl(JdbcTemplate jdbcTemplate, GetPageInf getPageInf) {
		super(jdbcTemplate);
		this.getPageInf = getPageInf;
	}

	/**
	 * 查询商品是否已存在
	 * @param goodsNo 商品编号
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String goodsNo) {
		return searchGoodsById(goodsNo) == null;
	}


	/**
	 * 添加商品
	 * @param goods 商品实体
	 * @return boolean
	 */
	@Override
	public boolean purchase(Goods goods) {
		String sql = "insert into goods values(?,?,?,?,?,?,?);";
		Object[] params = {goods.getGoodsNo(), goods.getShelvesAdr(), goods.getCartAdr(), goods.getGoodsPrice(), goods.getGoodsStock(), goods.getGoodsDesc(),goods.getGoodsState()};
		return jdbcTemplate.update(sql, params) > 0;
	}


	/**
	 * 通过商品编号查找商品
	 * @param goodsNo 商品编号
	 * @return Map<String, Object>
	 */
	@Override
	public Map<String, Object> searchGoodsById(String goodsNo) {
		String sql = "select * from goods where goods_no=?;";
		Object[] params = {goodsNo};
		try {
			return jdbcTemplate.queryForMap(sql, params);
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return null;
	}


	/**
	 * 修改商品信息
	 * @param goods 商品实体
	 * @return boolean
	 */
	@Override
	public boolean updateGoodsInf(Goods goods) {
		String sql = "update goods set goods_price=?, goods_desc=? where goods_no=?;";
		Object[] params = {goods.getGoodsPrice(), goods.getGoodsDesc(), goods.getGoodsNo()};
		return jdbcTemplate.update(sql, params) > 0;
	}


	/**
	 * 查找所有商品
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllGoods() {
		String sql = "select * from goods order by goods_stock;";
		return (List)jdbcTemplate.queryForList(sql);
	}


	/**
	 * 查找所有商品,分页显示
	 * @param curPage 当前所在页数
	 * @return PageBean
	 */
	@Override
	public PageBean getAllGoods(int curPage) {
		String sql = "select * from goods where goods_state='已上架' order by goods_stock";
		return getPageInf.getPageBean(sql, null, curPage);
	}


	/**
	 * 查找所有手机
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllPhone() {
		String sql = "select * from goods where goods_no like 'ph%' and goods_state='已上架';";
		return (List)jdbcTemplate.queryForList(sql);
	}

	/**
	 * 查找所有鞋类
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllShoes() {
		String sql = "select * from goods where goods_no like 'shoes%' and goods_state='已上架';";
		return (List) jdbcTemplate.queryForList(sql);
	}

	/**
	 * 通过商品编号删除商品
	 * @param goodsNo 商品编号
	 * @return  boolean
	 */
	@Override
	public boolean deleteGoodsById(String goodsNo) {
		String sql = "delete from goods where goods_no=?;";
		Object[] params = {goodsNo};
		return jdbcTemplate.update(sql, params) > 0;
	}


	/**
	 * 搜索商品
	 * @param parameter 搜索关键字
	 * @param curPage 当前所在页数
	 * @return PageBean
	 */
	@Override
	public PageBean search(String parameter, int curPage) {
		String sql = "select * from goods where goods_desc like ? and goods_state='已上架'";
		Object[] params = {parameter};
		return getPageInf.getPageBean(sql, params, curPage);
	}


	/**
	 * 上下架
	 * @param goods 商品实体
	 * @return int
	 */
	@Override
	public int onOffShelf(Goods goods) {
		String sql = "update goods set goods_state=? where goods_no=?";
		Object[] params = {goods.getGoodsState(), goods.getGoodsNo()};
		return jdbcTemplate.update(sql, params);
	}

	/**
	 * 减库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	@Override
	public int reduceStock(String goodsNo) {
		String sql = "update goods set goods_stock=goods_stock-1 where goods_no=?";
		Object[] params = {goodsNo};
		return jdbcTemplate.update(sql, params);
	}

	/**
	 * 加库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	@Override
	public int addStock(String goodsNo, int num) {
		String sql = "update goods set goods_stock=goods_stock+? where goods_no=?";
		Object[] params = {num, goodsNo};
		return jdbcTemplate.update(sql, params);
	}
}
