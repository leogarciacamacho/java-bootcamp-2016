package abstractFactory;

import java.sql.Connection;

public class NoSQLFactory extends ConnectionFactory {

	public Connection getConnection(String connectionType) {
		return null;											// no desarrollado
	}

}