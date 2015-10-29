package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.PartHandler;
import antinp1.rowprocessors.TypedRowProcessor;

public class BeanPartHandler<ID, K> extends BeanPartHandlerBasis<K>
		implements PartHandler<ID, K> {

	public BeanPartHandler(	TypedRowProcessor rowProcessor) {
		super(rowProcessor);
	}

	public K handlePart(ResultSet resultSet, ID id, TypedRowProcessor<ID> indexHandler) throws SQLException {
		if (id.equals(indexHandler.handle(resultSet))) {
			return handle(resultSet);
		} else {
			return null;
		}
	}

}
