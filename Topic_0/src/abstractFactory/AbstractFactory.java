package abstractFactory;

public class AbstractFactory {

		public ConnectionFactory getConnectionFactory(String factoryType) {
		
		if (factoryType.equalsIgnoreCase("SQL")) {
			return new SQLFactory();
		} else if (factoryType.equalsIgnoreCase("NoSQL")) {
			return new NoSQLFactory(); 
		}
		
		return null;
	}

}

