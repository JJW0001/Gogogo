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
	 * ��ѯ�û��Ƿ��Ѵ���
	 * @param userName �û���
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String userName){
		return iud.searchUserByName(userName) == null;
	}

	/**
	 * ע��
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
    public boolean addUser(User user) {
		//�Ȳ�ѯ���û����Ƿ�ע���
		if(isEmpty(user.getUserName()))
		{
			return iud.addUser(user);
		} else {
			return false;
		}
	}


	/**
	 * ��¼
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
	public boolean login(User user){
		return iud.login(user) != null;
	}


	/**
	 * ����ͷ��
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
	public boolean updateUserHead(User user) {
		return iud.updateUserHead(user);
	}


	/**
	 * ��ȡ�û���Ϣ
	 * @param userName �û���
	 * @return Map<String, Object>
	 */
	@Override
	public Map<String, Object> searchUserByName(String userName) {
		return iud.searchUserByName(userName);
	}
	
}
