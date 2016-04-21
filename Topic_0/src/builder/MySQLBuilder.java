package builder;

import java.sql.Connection;

public class MySQLBuilder implements DbBuilder {

	@Override
	public void buildHost() {
		MySQLConnection.setHost("localhost");
	}

	@Override
	public void buildPort() {
		MySQLConnection.setPort("3306");
	}

	@Override
	public void buildName() {
		MySQLConnection.setName("MySQLDb");
	}

	@Override
	public void buildUser() {
		MySQLConnection.setUser("root");
	}

	@Override
	public void buildPass() {
		MySQLConnection.setPass("root");
	}

	@Override
	public Connection getConnection() {
		return MySQLConnection.getInstance().getConnection();
	}

}
