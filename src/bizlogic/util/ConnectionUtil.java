package bizlogic.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * DBに接続するためのユーティルクラス
 *
 * @author Takayama
 *
 */
public class ConnectionUtil {

	// コネクションを取得するメソッド
	public static Connection getConnection() throws SQLException {

		// コネクション
		Connection con = null;

		try {
			Context ctx = new InitialContext();
			DataSource dc = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			con = dc.getConnection();
		} catch (NamingException e) {
			throw new SQLException(e.getMessage() + "：データソースの設定が正しく行われていません");
		}
		return con;
	}
}