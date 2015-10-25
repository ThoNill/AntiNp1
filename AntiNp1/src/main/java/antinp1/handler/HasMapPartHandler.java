package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import antinp1.PartHandler;


public class HasMapPartHandler<K, ID> extends BeanPartHandlerBasis<ID,K> 
       implements PartHandler<ID,HashMap<String,K>> { 
	private ResultSetHandler<String> hashKeyHandler;

	public HasMapPartHandler(ResultSetHandler<String> hashKeyHandler,
			ResultSetHandler<ID> indexHandler,
			BeanHandler<K> beanHanlder) {
		super(indexHandler, beanHanlder);
		this.hashKeyHandler = hashKeyHandler;
	}
	
	public HashMap<String,K> handlePart(ResultSet resultSet, ID id) throws SQLException {
		HashMap<String,K> resultHashMap = new HashMap<String,K>();
		while (id.equals(calculateId(resultSet))) {
			String key = hashKeyHandler.handle(resultSet);
			resultHashMap.put(key,handle(resultSet));
			resultSet.next();
		} 
		return resultHashMap;
	}

}
