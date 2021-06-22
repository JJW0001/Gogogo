package gogogo.controller;

import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 86155
 */
@Controller
public class GoodsController {
    private final IGoodsService igs;

    @Autowired
    public GoodsController(IGoodsService igs) {
        this.igs = igs;
    }


    /**
     * 获取所有商品，分页显示
     * @return 请求页面
     */
    @RequestMapping(value = "/GetAllGoodsServlet", method = RequestMethod.GET)
    public String getAllGoods() {
        return igs.getAllGoodsPage();
    }


    /**
     * 获取所有手机
     * @return 请求页面
     */
    @RequestMapping(value = "/GetAllPhoneServlet", method = RequestMethod.GET)
    public String getAllPhone(){
        return igs.getAllPhone();
    }


    /**
     * 获取所有鞋子
     * @return 请求页面
     */
    @RequestMapping(value = "/GetAllShoesServlet", method = RequestMethod.GET)
    protected String getAllShoes(){
        return igs.getAllShoes();
    }


    /**
     * 上下架商品
     * @param goods 商品信息
     * @return 请求页面
     */
    @RequestMapping(value = "/OnOffShelfServlet", method = RequestMethod.GET)
    public String onOffShelf(Goods goods){
        return igs.onOffShelf(goods);
    }


    /**
     * 添加商品
     * @param goods 商品信息
     * @return 请求页面
     */
    @RequestMapping(value = "/PurchaseServlet",method = RequestMethod.GET)
    public String purchase(Goods goods) {
        return igs.purchase(goods);
    }


    /**
     * 搜索商品
     * @return 请求页面
     */
    @RequestMapping(value = "/SearchServlet")
    public String search(){
        return igs.search();
    }
}
