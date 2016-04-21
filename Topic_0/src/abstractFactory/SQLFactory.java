package abstractFactory;

public class SQLFactory extends AbstractFactory {

	public AbstractSQL getSQL(String connectionType) {
		if(connectionType.equalsIgnoreCase("mysql")){
			return MySQLConnection.getInstance();
		}else if(connectionType.equalsIgnoreCase("oracle")){
			return OracleConnection.getInstance();
		}
		return null;
	}
	public AbstractNoSQL getNoSQL(String connectionType) {
		return null;
	}

}