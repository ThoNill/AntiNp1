package antinp1.handler;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import antinp1.PartHandler;

public class BeanPartHandlerBasis<ID, K>  {
	private ResultSetHandler<K> rowProcessor;
	private ResultSetHandler<ID> indexHandler;
	private Class kClass;

	
	public BeanPartHandlerBasis(ResultSetHandler<ID> indexHandler,ResultSetHandler<K> rowProcessor) {
		this.rowProcessor = rowProcessor;
		this.indexHandler = indexHandler;
		this.kClass = kClass;
	}
	
	protected ID calculateId(ResultSet resultSet) throws SQLException {
		return indexHandler.handle(resultSet);
	}


	protected K handle(ResultSet resultSet) throws SQLException {
		return rowProcessor.handle(resultSet);
	}
}
