package proxy;

import java.sql.Connection;

import singleton.DbSingleton;

public class ProxyDbAccesor {
	
	public Connection getConnection(){
		return DbSingleton.getInstance().getConnection();
	}

}
/* La idea en el programa principal es no instanciar un objeto tipo DbSingleton (a traves de DbSingleton.getInstance()), si no uno de tipo ProxyDbAccesor,
   y que recien se instancie el DbSingleton al momento de solicitarle la conexion al proxy */