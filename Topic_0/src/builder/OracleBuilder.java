package builder;

import java.sql.Connection;

public class OracleBuilder implements DbBuilder {

	@Override
	public void buildHost() {
		OracleConnection.setHost("localhost");
	}

	@Override
	public void buildPort() {
		OracleConnection.setPort("3306");
	}

	@Override
	public void buildName() {
		OracleConnection.setName("OracleDb");
	}

	@Override
	public void buildUser() {
		OracleConnection.setUser("root");
	}

	@Override
	public void buildPass() {
		OracleConnection.setPass("root");
	}

	@Override
	public Connection getConnection() {
		return OracleConnection.getInstance().getConnection();
	}
	
}
