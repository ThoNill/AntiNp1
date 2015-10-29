package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.PartHandler;
import antinp1.rowprocessors.TypedRowProcessor;

public class BeanPartHandler<ID, K> extends BeanPartHandlerBasis<ID, K>
		implements PartHandler<ID, K> {

	public BeanPartHandler(TypedRowProcessor<ID> indexHandler,
			TypedRowProcessor rowProcessor) {
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
