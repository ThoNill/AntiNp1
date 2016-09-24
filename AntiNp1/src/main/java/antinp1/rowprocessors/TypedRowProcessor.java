package antinp1.rowprocessors;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Thomas Nill
 * 
 * commons.dbUtils hat ResultSetHandler, die typisiert sind, aber ganze ResultSet verarbeiten,
 * w�hrend RowProzessor nicht typisiert ist.
 * 
 * Deshalb habe ich ein neues Interface TypedRowProcessor hinzugef�gt,
 * einen RowProcessor, der typisiert ist und formal dasselbe Interface wie
 * ResultSetHandler besitzt.
 *
 * @param <T>
 */
@FunctionalInterface
public interface TypedRowProcessor<T> {
	T handle(ResultSet rs) throws SQLException;

}
