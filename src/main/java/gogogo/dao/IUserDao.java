package gogogo.dao;

import java.util.List;
import java.util.Map;

import gogogo.entity.User;

/**
 * @author 86155
 */
public interface IUserDao {
	/**
	 * 添加用户
	 * @param user 用户实体
	 * @return boolean
	 */
	boolean addUser(User user);


	/**
	 * 通过用户名查找用户
	 * @param userName 用户名
	 * @return Map<String, Object>
	 */
	Map<String, Object> searchUserByName(String userName);


	/**
	 * 修改用户信息
	 * @param user 用户实体
	 * @return boolean
	 */
	boolean updateUserInf(User user);


	/**
	 * 更换头像
	 * @param user 用户实体
	 * @return boolean
	 */
	boolean updateUserHead(User user);


	/**
	 * 查找所有用户信息
	 * @return List<Object>
	 */
	List<User> getAllUser();


	/**
	 * 通过用户名删除用户
	 * @param userName 用户名
	 * @return boolean
	 */
	boolean deleteUserByName(String userName);


	/**
	 * 用户登录
	 * @param user 用户实体
	 * @return boolean
	 */
	User login(User user);
}
