package antinp1;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PartHandler<ID, K> {
	K handlePart(ResultSet resultSet, ID id) throws SQLException;
}
