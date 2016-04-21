package builder;

import java.sql.Connection;

public interface DbBuilder {
	public void buildHost();
	public void buildPort();
	public void buildName();
	public void buildUser();
	public void buildPass();
	public Connection getConnection();
}
