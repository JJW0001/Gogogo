package gogogo.dao.impl;

import gogogo.dao.IUserDao;
import gogogo.entity.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author 86155
 */
@SuppressWarnings("all")
@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	/**
	 * ��ѯ�û��Ƿ��Ѵ���
	 * @param userName �û���
	 * @return boolean
	 */
	@Override
    public boolean isEmpty(String userName){
		return searchUserByName(userName) == null;
	}


	/**
	 * ����û�
	 * @param user �û�ʵ��
	 * @return  boolean
	 */
	@Override
	public boolean addUser(User user){
		String sql = "insert into user values(?,?,?,?,?);";
		Object[] params = {user.getUserName(), user.getUserPwd(), user.getUserTel(), user.getUserEmail(),user.getUserHead()};
		return jdbcTemplate.update(sql, params) > 0;
	}


	/**
	 * ͨ���û��������û�
	 * @param userName �û���
	 * @return Map<String, Object>
	 */
	@Override
	public Map<String, Object> searchUserByName(String userName){
		String sql = "select * from user where user_name = ?;";
		Object[] params = {userName};
		try {
			return jdbcTemplate.queryForMap(sql, params);
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return null;
	}


	/**
	 * �޸��û���Ϣ
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
	public boolean updateUserInf(User user){
		String sql = "update user set user_pwd=?, user_tel=?, user_email=?, user_head=? where user_name=?;";
		Object[] params = {user.getUserPwd(), user.getUserTel(), user.getUserEmail(), user.getUserHead(), user.getUserName()};
		return jdbcTemplate.update(sql, params) > 0;
	}


	/**
	 * ����ͷ��
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
	public boolean updateUserHead(User user){
		String sql = "update user set user_head=? where user_name=?;";
		Object[] params = {user.getUserHead(), user.getUserName()};
		return jdbcTemplate.update(sql, params) > 0;
	}


	/**
	 * ���������û���Ϣ
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllUser(){
		String sql = "select * from user;";
		return (List) jdbcTemplate.queryForList(sql);
	}


	/**
	 * ͨ���û���ɾ���û�
	 * @param userName �û���
	 * @return boolean
	 */
	@Override
	public boolean deleteUserByName(String userName) {
		String sql = "delete from user where user_name=?";
		Object[] params = {userName};
		return jdbcTemplate.update(sql, params) > 0;
	}

	/**
	 * �û���¼
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
	public boolean login(User user){
		String sql = "select * from user where user_name=? and user_pwd=?;";
		Object[] params = {user.getUserName(),user.getUserPwd()};
		Map<String, Object> map = null;
		try {
			return jdbcTemplate.queryForMap(sql, params) != null;
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return map != null;
	}
}
