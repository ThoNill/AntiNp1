package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import antinp1.PartHandler;
import antinp1.rowprocessors.TypedRowProcessor;

public class HashMapPartHandler<K, ID> extends BeanPartHandlerBasis<ID, K>
		implements PartHandler<ID, HashMap<String, K>> {
	private TypedRowProcessor<String> hashKeyHandler;

	public HashMapPartHandler(TypedRowProcessor<String> hashKeyHandler,
			TypedRowProcessor<ID> indexHandler, TypedRowProcessor rowProcessor) {
		super(indexHandler, rowProcessor);
		this.hashKeyHandler = hashKeyHandler;
	}

	public HashMap<String, K> handlePart(ResultSet resultSet, ID id)
			throws SQLException {
		HashMap<String, K> resultHashMap = new HashMap<String, K>();
		boolean hasNext = true;

		while (hasNext && id.equals(calculateId(resultSet))) {
			String key = hashKeyHandler.handle(resultSet);
			resultHashMap.put(key, handle(resultSet));
			hasNext = resultSet.next();
		}
		return resultHashMap;
	}

}
