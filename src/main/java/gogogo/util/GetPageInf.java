package gogogo.util;

import gogogo.bean.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@SuppressWarnings("all")
@Component
public class GetPageInf {
	/**
	 * 每页两行，每行5个商品
	 */
	private static final int PAGE_SIZE = 2*5;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GetPageInf(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 执行数据库查询操作时，返回结果的记录总数。
	 * @param sql sql
	 * @param params 参数
	 * @return long
	 */
	private long getTotalRows(String sql, Object[] params) {
		sql = sql.toLowerCase();
		String countSql;
		String string1 = "group";
		Map<String, Object> oneField = null;
		if(sql.contains(string1)){
			countSql = "select count(*) from ("+sql+") as tempNum";
		}else{
			countSql = "select count(*) as tempNum "+ sql.substring(sql.indexOf("from"));
		}

		try {
			oneField = jdbcTemplate.queryForMap(countSql,params);
		}catch (EmptyResultDataAccessException e){
			e.printStackTrace();
		}

		if(oneField != null){
			return (long) oneField.get("tempNum");
		}else{
			return 0;
		}
	}

	/**
	 * 分页显示查询结果时，将当前页中的所有信息封装到PageBean中
	 * @param sql sql
	 * @param params 参数
	 * @param curPage 当前页数
	 * @return PageBean
	 */
	public PageBean getPageBean(String sql, Object[] params, int curPage){
		String newSql = sql + " limit " + (curPage-1)* PAGE_SIZE +","+ PAGE_SIZE;
		System.out.println(jdbcTemplate);
		List<Map<String, Object>> data = jdbcTemplate.queryForList(newSql,params);
		PageBean pb=new PageBean();
		pb.setCurPage(curPage);
		pb.setPageSize(PAGE_SIZE);
		pb.setTotalRows(getTotalRows(sql, params));
		pb.setData(data);
		return pb;
	}
}
