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
     * ��ȡ������Ʒ����ҳ��ʾ
     * @return ����ҳ��
     */
    @RequestMapping(value = "/GetAllGoodsServlet", method = RequestMethod.GET)
    public String getAllGoods() {
        return igs.getAllGoodsPage();
    }


    /**
     * ��ȡ�����ֻ�
     * @return ����ҳ��
     */
    @RequestMapping(value = "/GetAllPhoneServlet", method = RequestMethod.GET)
    public String getAllPhone(){
        return igs.getAllPhone();
    }


    /**
     * ��ȡ����Ь��
     * @return ����ҳ��
     */
    @RequestMapping(value = "/GetAllShoesServlet", method = RequestMethod.GET)
    protected String getAllShoes(){
        return igs.getAllShoes();
    }


    /**
     * ���¼���Ʒ
     * @param goods ��Ʒ��Ϣ
     * @return ����ҳ��
     */
    @RequestMapping(value = "/OnOffShelfServlet", method = RequestMethod.GET)
    public String onOffShelf(Goods goods){
        return igs.onOffShelf(goods);
    }


    /**
     * �����Ʒ
     * @param goods ��Ʒ��Ϣ
     * @return ����ҳ��
     */
    @RequestMapping(value = "/PurchaseServlet",method = RequestMethod.GET)
    public String purchase(Goods goods) {
        return igs.purchase(goods);
    }


    /**
     * ������Ʒ
     * @return ����ҳ��
     */
    @RequestMapping(value = "/SearchServlet")
    public String search(){
        return igs.search();
    }
}
