/**
 * @compnay 清源科技有限公司
 * @version bit 1.0 
 * @function 初始化数据库连接以及配置变量
 * @author fql
 * @package bk.test.main.utils
 * @class bk.test.main.utils.DbUtils
 *
 */
package aa.com.resources.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.map.HashedMap;

/**
 * function 初始化数据库信息
 * 
 * @author fql
 * 
 */
public final class DbUtils {
	public static Connection conn = null;

	/**
	 * @function 初始化数据库信息
	 * @param
	 * @return conn
	 * 
	 **/
	public static final  Connection init() {
		Properties p = new Properties();
		InputStream in = Object.class
				.getResourceAsStream("/config/properties/DataSource.properties");
		try {
			p.load(in);
			// LogUtils.logger.info("db properties load  is success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LogUtils.error("db get connection is error" + e.getMessage());
		}
		try {
			Class.forName(p.getProperty("className"));
			// LogUtils.logger.error("db driver load is success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LogUtils.error("db driver load is error"+ e.getMessage());
		}

		try {
			conn = DriverManager.getConnection(p.getProperty("url"),
					p.getProperty("userName"), p.getProperty("passWord"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogUtils.error("db connection  load is error"+ e.getMessage());
		}
		return conn;
	}

	// public static void main(String[] args) throws SQLException {
	// List list = null;
	// HashMap<String, String> map = new HashMap<String, String>();
	// new DbUtils().init();
	// Statement st = conn.createStatement();
	// ResultSet rs = st.executeQuery("select * from tb_admin_info");
	// ResultSetMetaData resultMetaData = rs.getMetaData();
	// int cols = resultMetaData.getColumnCount();
	// for (int i = 1; i <= cols; i++) {
	// map.put(resultMetaData.getColumnName(i),
	// resultMetaData.getColumnName(i));
	// }
	// list = new ArrayList<HashMap<Object, Object>>();
	// HashMap<Object, Object> map2 = new HashMap<Object, Object>();
	// while (rs.next()) {
	// for (Map.Entry<String, String> m : map.entrySet()) {
	// map2.put(m.getKey(), rs.getObject(m.getKey()));
	// }
	// list.add(map2);
	// }
	// System.out.println(list);
	// }

	public static void rollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogUtils.error("db rollback is error" + e.getMessage());
		}
	}

	public static void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogUtils.error("db rollback is error" + e.getMessage());

		}
	}

	public static Statement createStatement() {
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogUtils.error("connection get connection is error"
					+ e.getMessage());
		}
		return statement;
	}
}
