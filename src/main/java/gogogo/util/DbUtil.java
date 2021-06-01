package gogogo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Deprecated
public class DbUtil {
	/**
	 *链接数据库信息（驱动、数据库、用户名、密码)
	 */
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/gogogo";
	private static String username="root";
	private static String password="root";
	/**
	 * 获取连接对象
	 */
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public DbUtil(){
	}


	public void setDriver(String driver) {
		DbUtil.driver = driver;
	}
	public void setUrl(String url) {
		DbUtil.url = url;
	}
	public void setUsername(String username) {
		DbUtil.username = username;
	}
	public void setPassword(String password) {
		DbUtil.password = password;
	}


	/**
	 * 获取连接对象
	 * @return Connection
	 */
	private static Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


	/**
	 * 获取语句对象
	 * @param sql sql
	 * @return PreparedStatement
	 */
	private static PreparedStatement getPrepareStatement(String sql) {
		try {
			pstmt = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}


	/**
	 * 给pstmt的SQL语句设置参数（要求参数以数组形式给出）
	 * @param sql  sql
	 * @param params 参数
	 */
	private static void setParams(String sql, Object[] params) {
		pstmt = DbUtil.getPrepareStatement(sql);
		if(params != null){
			for (int i = 0; i < params.length; i++){
				try {
					pstmt.setObject(i + 1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 *  执行数据库查询操作时，将返回的结果封装到List对象中
	 * @param sql sql
	 * @param params 参数
	 * @return List<Object>
	 */
	public static List<Object> getAllFields(String sql, Object[] params){
		List<Object> list = new ArrayList<>();
		try {
			DbUtil.setParams(sql, params);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			while(rs.next()) {
				Map<String,Object> m = new HashMap<>(255);
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String colName = rsmd.getColumnName(i);
					m.put(colName, rs.getObject(colName));
				}
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
	}


	/**
	 * 执行数据库查询操作时，将返回的结果封装到map对象中
	 * @param sql sql
	 * @param params 参数
	 * @return Map<String, Object>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getOneField(String sql, Object[] params){
		List<Object> list = getAllFields(sql, params);
		assert list != null;
		if(list.isEmpty()) {
			return null;
		} else {
			return (Map<String, Object>)list.get(0);
		}
	}


	/**
	 * 更新数据库时调用的update方法
	 * @param sql sal
	 * @param params 参数
	 * @return int
	 */
	public static int update(String sql, Object[] params) {
		// 表示受影响的记录行数
		int recNo = 0;
		try {
			// 根据sql语句和params，设置pstmt对象
			setParams(sql, params);
			// 执行更新操作
			recNo = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return recNo;
	}

	/**
	 * 关闭对象
	 */
	private static void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException ignored) {
		}
	}
}
