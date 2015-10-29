package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.PartHandler;
import antinp1.rowprocessors.TypedRowProcessor;

public class ColumnHandler<ID, K> implements PartHandler<ID, K> {

	private int column;

	public ColumnHandler(int column) {
		super();
		this.column = column;
	}

	public K handlePart(ResultSet resultSet, ID id, TypedRowProcessor<ID> indexHandler) throws SQLException {
		return (K) resultSet.getObject(column);
	}

}
