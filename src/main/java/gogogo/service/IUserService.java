package gogogo.service;

import java.util.Map;

import gogogo.entity.User;

/**
 * @author 86155
 */
public interface IUserService {

	/**
	 * 注册
	 * @param user 用户实体
	 * @return boolean
	 */
	boolean addUser(User user);


	/**
	 * 登录
	 * @param user 用户实体
	 * @return boolean
	 */
	boolean login(User user);


	/**
	 * 更换头像
	 * @param user 用户实体
	 * @return  boolean
	 */
	boolean updateUserHead(User user);


	/**
	 * 获取用户信息
	 * @param userName 用户名
	 * @return Map<String, Object>
	 */
	Map<String, Object> searchUserByName(String userName);
}
