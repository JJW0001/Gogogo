package gogogo;

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ICartsDaoTest {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    private final ICartsService cartsService = ioc.getBean(ICartsService.class);

    /**
     * 加入购物车
     */
    @Test
    public void TestAddCart() {

    }

    /**
     * 获取某用户购物车
     */
    @Test
    public void testGetCart(){

    }

    /**
     * 删除某用户购物者中某样商品
     */
    @Test
    public void testDeleteUserCartGoods(){
        Carts cart = new Carts(null,"www", "ph9", 0, null);
        String success = cartsService.deleteUserCartGoods(cart);
        System.out.println(success);
    }
}
