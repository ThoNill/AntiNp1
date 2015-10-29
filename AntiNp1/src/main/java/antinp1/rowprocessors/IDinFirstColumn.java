package antinp1.rowprocessors;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IDinFirstColumn implements TypedRowProcessor<Integer> {

	public Integer handle(ResultSet rs) throws SQLException {
		return new Integer(rs.getInt(1));
	}

}
