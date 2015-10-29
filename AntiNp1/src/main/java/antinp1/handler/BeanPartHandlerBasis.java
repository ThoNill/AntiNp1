package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.rowprocessors.TypedRowProcessor;

public class BeanPartHandlerBasis<K> {
	private TypedRowProcessor<K> rowProcessor;
	;

	public BeanPartHandlerBasis(TypedRowProcessor<K> rowProcessor) {
		this.rowProcessor = rowProcessor;
	}

	protected K handle(ResultSet resultSet) throws SQLException {
		return rowProcessor.handle(resultSet);
	}
}
