package gogogo.service.impl;

import gogogo.dao.IUserDao;
import gogogo.entity.User;
import gogogo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 86155
 */
@Service
public class UserServiceImpl implements IUserService {

	private final IUserDao iud;

	@Autowired
	public UserServiceImpl(IUserDao iud) {
		this.iud = iud;
	}

	/**
	 * 查询用户是否已存在
	 * @param userName 用户名
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String userName){
		return iud.searchUserByName(userName) == null;
	}

	/**
	 * 注册
	 * @param user 用户实体
	 * @return boolean
	 */
	@Override
    public boolean addUser(User user) {
		//先查询该用户名是否被注册过
		if(isEmpty(user.getUserName()))
		{
			return iud.addUser(user);
		} else {
			return false;
		}
	}


	/**
	 * 登录
	 * @param user 用户实体
	 * @return boolean
	 */
	@Override
	public boolean login(User user){
		return iud.login(user) != null;
	}


	/**
	 * 更换头像
	 * @param user 用户实体
	 * @return boolean
	 */
	@Override
	public boolean updateUserHead(User user) {
		return iud.updateUserHead(user);
	}


	/**
	 * 获取用户信息
	 * @param userName 用户名
	 * @return Map<String, Object>
	 */
	@Override
	public Map<String, Object> searchUserByName(String userName) {
		return iud.searchUserByName(userName);
	}
	
}
