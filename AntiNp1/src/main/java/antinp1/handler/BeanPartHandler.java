package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import antinp1.PartHandler;

public class BeanPartHandler<ID, K> extends BeanPartHandlerBasis<ID, K> implements PartHandler<ID, K> {

	
	

	public BeanPartHandler(ResultSetHandler<ID> indexHandler,
			ResultSetHandler rowProcessor) {
		super(indexHandler, rowProcessor);
	}

	public K handlePart(ResultSet resultSet, ID id) throws SQLException {
		if (id.equals(calculateId(resultSet))) {
			return handle(resultSet);
		} else {
			return null;
		}
	}

}
