package abstractFactory;

public class NoSQLFactory extends AbstractFactory {

	@Override
	public AbstractSQL getSQL(String connectionType) {
		return null;
	}

	@Override
	public AbstractNoSQL getNoSQL(String connectionType) {
		// no desarrollado
		return null;
	}

}