package gogogo;

import gogogo.dao.IUserDao;
import gogogo.entity.User;
import gogogo.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IUserDaoTest {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    private final IUserService userService = ioc.getBean(IUserService.class);
    private final IUserDao userDao = ioc.getBean(IUserDao.class);

    /**
     * 根据用户名查询用户信息
     */
    @Test
    public void testUpdate() {

    }

    /**
     * 添加用户
     */
    @Test
    public void testAddUser(){
        User user = new User("jjw", "123456788", "15507780231", null);
        boolean addUser = userService.addUser(user);
        System.out.println(addUser);
    }

    /**
     * 登录
     */
    @Test
    public void testLogin(){
        User user = new User("jjw", "123456788");
        boolean login = userService.login(user);
        System.out.println(login);
    }

    /**
     * 更换头像
     */
    @Test
    public void testUpdateHead(){
        User user = new User("jjw", null,null,null,"images/WIN_20191023_17_57_47_Pro.jpg");
        boolean login = userService.updateUserHead();
        System.out.println(login);
    }

    /**
     * 获取用户信息
     */
    @Test
    public void testGetUser(){

    }

    /**
     * 修改用户信息
     */
    @Test
    public void testUpdateUserInf(){
        User user = new User("jjw", null,"18278809491",null,"images/WIN_20191023_17_57_47_Pro.png");
        boolean success = userDao.updateUserInf(user);
        System.out.println(success);
    }

    /**
     * 查找所有用户信息
     */
    @Test
    public void testGetAllUser(){
        List<User> allUser = userDao.getAllUser();
        for (User user : allUser){
            System.out.println(user);
        }
    }

    /**
     * 通过用户名删除用户
     */
    @Test
    public void testDeleteUserByName(){
        boolean success = userDao.deleteUserByName("jjw");
        System.out.println(success);
    }
}
