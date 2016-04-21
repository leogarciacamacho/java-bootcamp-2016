package builder;

import java.sql.Connection;

public class MySQLBuilder implements DbBuilder {

	@Override
	public void buildHost() {
		MySQLSingleton.setHost("localhost");
	}

	@Override
	public void buildPort() {
		MySQLSingleton.setPort("3306");
	}

	@Override
	public void buildName() {
		MySQLSingleton.setName("MySQLDb");
	}

	@Override
	public void buildUser() {
		MySQLSingleton.setUser("root");
	}

	@Override
	public void buildPass() {
		MySQLSingleton.setPass("root");
	}

	@Override
	public Connection getConnection() {
		return MySQLSingleton.getInstance().getConnection();
	}

}
