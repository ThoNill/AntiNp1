package antinp1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;

public class IDinFirstColumn implements ResultSetHandler<Integer> {

	public Integer handle(ResultSet rs) throws SQLException {
		return new Integer(rs.getInt(1));
	}

	

}
