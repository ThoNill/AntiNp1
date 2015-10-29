package antinp1;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.rowprocessors.TypedRowProcessor;

public interface PartHandler<ID, K> {
	K handlePart(ResultSet resultSet, ID id,TypedRowProcessor<ID> indexHandler) throws SQLException;
}
