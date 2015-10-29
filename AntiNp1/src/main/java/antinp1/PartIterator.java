package antinp1;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.rowprocessors.TypedRowProcessor;

public class PartIterator<ID extends Comparable<ID>, K> {
	private TypedRowProcessor<ID> indexHandler;
	private PartHandler<ID, K> partHandler;

	private ID lastID;
	private K lastObject;
	private ResultSet resultSet;
	private Query query;
	private boolean executed = false;

	public PartIterator(TypedRowProcessor<ID> indexHandler,
			PartHandler<ID, K> convertExecute) {
		super();
		this.indexHandler = indexHandler;
		this.partHandler = convertExecute;

	}

	public K getObjectWithId(ID id) throws SQLException {
		executeQuery();
		if (lastID != null) {
			if (lastID.compareTo(id) > 0) {
				return null;
			}
			if (id.equals(lastID)) {
				return lastObject;
			}
		}
		searchId(id);
		createObject();
		if (id.equals(lastID)) {
			return lastObject;
		}
		return null;
	}

	public void close() throws SQLException {
		lastID = null;
		lastObject = null;
		if (resultSet != null) {
			resultSet.close();
			resultSet = null;
		}
	}

	private ID calculateId(ResultSet resultSet) throws SQLException {
		return indexHandler.handle(resultSet);
	}

	private void executeQuery() throws SQLException {
		if (!executed) {
			executed = true;
			resultSet = query.execute();
			resultSet.next();
		}
	};

	private void createObject() throws SQLException {
		if (lastID != null && resultSet != null) {
			lastObject = partHandler.handlePart(resultSet, lastID);
		} else {
			lastObject = null;
		}
	}

	private void searchId(ID id) throws SQLException {
		if (resultSet != null) {
			lastID = calculateId(resultSet);
			while (lastID != null && lastID.compareTo(id) < 0) {
				if (resultSet.next()) {
					lastID = calculateId(resultSet);
				} else {
					close();
				}
			}
		} else {
			lastID = null;
		}
	}

	public void setQuery(Query query) throws SQLException {
		close();
		this.query = query;
		this.executed = false;
	}

}
