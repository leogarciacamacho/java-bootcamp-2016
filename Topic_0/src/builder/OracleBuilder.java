package builder;

import java.sql.Connection;

public class OracleBuilder implements DbBuilder {

	@Override
	public void buildHost() {
		OracleSingleton.setHost("localhost");
	}

	@Override
	public void buildPort() {
		OracleSingleton.setPort("3306");
	}

	@Override
	public void buildName() {
		OracleSingleton.setName("OracleDb");
	}

	@Override
	public void buildUser() {
		OracleSingleton.setUser("root");
	}

	@Override
	public void buildPass() {
		OracleSingleton.setPass("root");
	}

	@Override
	public Connection getConnection() {
		return OracleSingleton.getInstance().getConnection();
	}
	
}
