package abstractFactory;

import java.sql.Connection;

public class SQLFactory extends ConnectionFactory {

	public Connection getConnection(String connectionType) {
		if(connectionType.equalsIgnoreCase("mysql")){
			return MySQLSingleton.getInstance().getConnection();
		}else if(connectionType.equalsIgnoreCase("oracle")){
			return OracleSingleton.getInstance().getConnection();
		}
		return null;
	}

}