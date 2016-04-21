package abstractFactory;

public class FactoryProducer {

		public static AbstractFactory getFactory(String factoryType) {
		
		if (factoryType.equalsIgnoreCase("SQL")) {
			return new SQLFactory();
		} else if (factoryType.equalsIgnoreCase("NoSQL")) {
			return new NoSQLFactory(); 
		}
		
		return null;
	}

}

