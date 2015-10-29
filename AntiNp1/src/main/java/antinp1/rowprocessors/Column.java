package antinp1.rowprocessors;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Column<K> implements TypedRowProcessor<K> {

	private int column;

	public Column(int column) {
		super();
		this.column = column;
	}

	public K handle(ResultSet resultSet) throws SQLException {
		return (K) resultSet.getObject(column);
	}

}
