package gogogo.controller;

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 86155
 */
@Controller
public class CartController {
    private final ICartsService ics;

    @Autowired
    public CartController(ICartsService ics){
        this.ics = ics;
    }

    /**
     * ���빺�ﳵ
     * @param userName �û���
     * @param goodsNo ��Ʒ���
     * @param thisPage ��ǰҳ
     * @param curPage ��ǰ��ҳ
     * @param search �����ؼ���
     * @return ����ҳ��
     */
    @RequestMapping(value = "/AddCart", method = RequestMethod.GET)
	public String addCart(@RequestParam(value = "userName") String userName,
						  @RequestParam(value = "goodsNo") String goodsNo,
						  @RequestParam(value = "thisPage") String thisPage,
						  @RequestParam(value = "curPage",required = false, defaultValue = "") String curPage,
						  @RequestParam(value = "search",required = false, defaultValue = "") String search){


		String page = ics.addCart(userName, goodsNo, thisPage, curPage, search);
		return "forward:/" + page;
	}


	/**
	 * ɾ�����ﳵ��Ʒ
	 * @param cart ���ﳵ��Ϣ
	 * @return ����ҳ��
	 */
	@RequestMapping(value = "/DeleteUserCartGoodsServlet", method = RequestMethod.GET)
	public String deleteCartGoods(Carts cart){
		String page = ics.deleteUserCartGoods(cart);
		return "forward:/" + page;
	}


	/**
	 * ��ȡ�û����ﳵ��Ϣ
	 * @param userName �û���
	 * @return ����ҳ��
	 */
	@RequestMapping(value = "/UserCartServlet", method = RequestMethod.GET)
	public String userCart(@RequestParam("userName") String userName) {
		return ics.getCart(userName);
	}
}
