package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import antinp1.PartHandler;

public class Column<K> implements ResultSetHandler<K> {

	private int column;

	public Column(int column) {
		super();
		this.column = column;
	}

	public K handle(ResultSet resultSet) throws SQLException {
		return (K) resultSet.getObject(column);
	}

}
