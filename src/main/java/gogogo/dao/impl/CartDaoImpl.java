package gogogo.dao.impl;

import gogogo.dao.ICartsDao;
import gogogo.entity.Carts;
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
public class CartDaoImpl extends BaseDao implements ICartsDao {
    public CartDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * 查询某用户购物车中是否有某件商品
     * @param cart carts实体
     * @return boolean
     */
    @Override
    public boolean isEmpty(Carts cart) {
        return getGoodsNum(cart.getUserName(), cart.getGoodsNo()) == null;
    }


    /**
     * 加入购物车
     * @param cart carts实体
     * @return boolean
     */
    @Override
    public boolean addCarts(Carts cart) {
        String sql;
        Object[] params;
        //数量为1说明该商品未加入过购物车
        if(cart.getAddNum()==1){
            sql = "insert into carts values(?,?,?,?,?);";
            params = new Object[5];
            params[0] = cart.getCartsNo();
            params[1] = cart.getUserName();
            params[2] = cart.getGoodsNo();
            params[3] = cart.getAddNum();
            params[4] = cart.getAddTime();
        }
        else{
            sql = "update carts set add_num=? where carts_no=?;";
            params = new Object[2];
            params[0] = cart.getAddNum();
            params[1] = cart.getCartsNo();
        }

        return jdbcTemplate.update(sql, params) > 0;
    }


    /**
     * 修改购物车信息
     * @param cart carts实体
     * @return boolean
     */
    @Override
    public boolean updateCarts(Carts cart) {
        String sql = "update carts set buy_num=? where user_name=? and goods_no=?;";
        Object[] params = {cart.getUserName(), cart.getGoodsNo(), cart.getAddNum(), cart.getAddTime(), cart.getCartsNo()};
        return jdbcTemplate.update(sql, params) > 0;
    }


    /**
     * 获取某用户购物车
     * @param cart carts实体
     * @return List<Object>
     */
    @Override
    public List<Object> getCart(Carts cart) {
        String sql = "select g.goods_no, g.cart_adr, g.goods_desc, g.goods_price, c.add_num from carts c join goods g on c.goods_no = g.goods_no where c.user_name = ? order by add_time desc;";
        Object[] params = {cart.getUserName()};
        return (List)jdbcTemplate.queryForList(sql,params);
    }


    /**
     * 删除某用户购物车某件商品
     * @param cart carts实体
     * @return boolean
     */
    @Override
    public boolean deleteUserCartGoods(Carts cart) {
        String sql = "delete from carts where user_name = ? and goods_no = ?;";
        Object[] params = {cart.getUserName(), cart.getGoodsNo()};
        return jdbcTemplate.update(sql, params) > 0;
    }


    /**
     * 获取某用户加入购物车的某样商品数量和序号
     * @param userName 用户名
     * @param goodsNo 商品编号
     * @return Object[]
     */
    @Override
    public Object[] getGoodsNum(String userName, String goodsNo){
        String sql = "select carts_no, add_num from carts where user_name = ? and goods_no = ?;";
        Object[] params = {userName, goodsNo};
        Map<String, Object> map = null;

        try {
            map = jdbcTemplate.queryForMap(sql, params);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

        if(map != null){
            return new Object[]{map.get("carts_no"), map.get("add_num")};
        }else{
            return null;
        }
    }
}
