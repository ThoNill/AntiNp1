package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import antinp1.PartHandler;


public class ListPartHandler<K, ID> extends BeanPartHandlerBasis<ID,K> 
       implements PartHandler<ID,List<K>> { 

	public ListPartHandler(ResultSetHandler<ID> indexHandler,
			BeanHandler<K> beanHanlder) {
		super(indexHandler, beanHanlder);
	}
	
	public List<K> handlePart(ResultSet resultSet, ID id) throws SQLException {
		List<K> resultList = new ArrayList<K>();
		while (id.equals(calculateId(resultSet))) {
			resultList.add(handle(resultSet));
			resultSet.next();
		} 
		return resultList;
	}

}
