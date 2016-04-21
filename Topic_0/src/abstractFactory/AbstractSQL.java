package abstractFactory;

import java.sql.Connection;

public abstract class AbstractSQL {
	
	public abstract Connection getConnection();

}
