package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.rowprocessors.TypedRowProcessor;

public class BeanPartHandlerBasis<ID, K> {
	private TypedRowProcessor<K> rowProcessor;
	private TypedRowProcessor<ID> indexHandler;

	public BeanPartHandlerBasis(TypedRowProcessor<ID> indexHandler,
			TypedRowProcessor<K> rowProcessor) {
		this.rowProcessor = rowProcessor;
		this.indexHandler = indexHandler;
	}

	protected ID calculateId(ResultSet resultSet) throws SQLException {
		return indexHandler.handle(resultSet);
	}

	protected K handle(ResultSet resultSet) throws SQLException {
		return rowProcessor.handle(resultSet);
	}
}
