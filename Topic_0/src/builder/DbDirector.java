package builder;

import java.sql.Connection;

public class DbDirector {
	private DbBuilder dbBuilder;
	
	public DbDirector(DbBuilder dbBuilder) {
		this.dbBuilder = dbBuilder;
	}
	
	public void buildDb() {
		dbBuilder.buildHost();
		dbBuilder.buildPort();
		dbBuilder.buildName();
		dbBuilder.buildUser();
		dbBuilder.buildPass();
	}
	
	public Connection getConnection(){
		return dbBuilder.getConnection();
		
	}
}
