package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import antinp1.PartHandler;

public class BeanPartHandlerBasis<ID, K>  {
	private BeanHandler<K> beanHandler;
	private ResultSetHandler<ID> indexHandler;

	
	public BeanPartHandlerBasis(ResultSetHandler<ID> indexHandler,BeanHandler<K> beanHanlder) {
		this.beanHandler = beanHanlder;
		this.indexHandler = indexHandler;
	}
	
	protected ID calculateId(ResultSet resultSet) throws SQLException {
		return indexHandler.handle(resultSet);
	}


	protected K handle(ResultSet resultSet) throws SQLException {
		return beanHandler.handle(resultSet);
	}
}
