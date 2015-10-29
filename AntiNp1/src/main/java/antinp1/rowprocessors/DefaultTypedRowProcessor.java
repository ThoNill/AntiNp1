package antinp1.rowprocessors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.RowProcessor;

public class DefaultTypedRowProcessor<T> implements TypedRowProcessor<T> {
	RowProcessor rowProzessor;
	private final Class<? extends T> type;

	public DefaultTypedRowProcessor(Class<? extends T> type,
			RowProcessor rowProzessor) {
		super();
		this.type = type;
		this.rowProzessor = rowProzessor;
	}

	public T handle(ResultSet rs) throws SQLException {
		return this.rowProzessor.toBean(rs, this.type);
	}

}
