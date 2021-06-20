package gogogo;

import gogogo.bean.PageBean;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Goods;
import gogogo.service.ICartsService;
import gogogo.service.IGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class IGoodsDaoTest {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    private final IGoodsService goodsService = ioc.getBean(IGoodsService.class);
    private final IGoodsDao goodsDao = ioc.getBean(IGoodsDao.class);

    /**
     * 根据id获取某样商品
     */
    @Test
    public void testSearchGoodsById(){
        Map<String, Object> map = goodsDao.searchGoodsById("ph1");
        System.out.println(map);
    }

    /**
     * 查找所有商品
     */
    @Test
    public void testGetAllGoods(){
        List<Map<String, Object>> allGoods = goodsService.getAllGoods();
        for (Map<String, Object> map : allGoods){
            System.out.println(map);
        }
    }

    /**
     * 查询所有商品分页显示
     */
    @Test
    public void testGetAllGoodsPage(){
        PageBean allGoods = goodsService.getAllGoods(1);
        for (Map<String,Object> map : allGoods.getData()){
            System.out.println(map);
        }
    }

    /**
     * 查找所有手机
     */
    @Test
    public void testGetAllPhone(){
        List<Map<String, Object>> allPhone = goodsService.getAllPhone();
        for (Map<String, Object> map : allPhone){
            System.out.println(map);
        }
    }

    /**
     * 查找所有鞋类
     */
    @Test
    public void testGetAllShoes(){
        List<Map<String, Object>> allShoes = goodsService.getAllShoes();
        for (Map<String, Object> map : allShoes){
            System.out.println(map);
        }
    }

    /**
     * 搜索
     */
    @Test
    public void testSearch(){
        PageBean search = goodsService.search("%HUAWEI%", 1);
        for (Map<String, Object> map : search.getData()){
            System.out.println(map);
        }
    }

    /**
     * 更新某样商品信息
     */
    @Test
    public void testUpdateGoodsInf(){
        Goods goods = new Goods();
        goods.setGoodsNo("ph1");
        goods.setGoodsPrice(3200F);
        goods.setGoodsStock(789);
        goods.setGoodsDesc("畅享10Plus 手机（华为直供 现货速发）下单即送好礼 天空之境 全网通（4G+128G）");
        boolean success = goodsService.updateGoodsInf(goods);
        System.out.println(success);
    }
}
