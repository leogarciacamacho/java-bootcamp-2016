package abstractFactory;

public abstract class AbstractFactory {
	public abstract AbstractSQL getSQL(String connectionType);
	public abstract AbstractNoSQL getNoSQL (String connectionType);
}