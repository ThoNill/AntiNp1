package antinp1;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface Query {
	ResultSet execute() throws SQLException;
}
