package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import antinp1.PartHandler;
import antinp1.rowprocessors.TypedRowProcessor;

public class HashMapPartHandler<K, ID> extends BeanPartHandlerBasis<K>
		implements PartHandler<ID, Map<String, K>> {
	private TypedRowProcessor<String> hashKeyHandler;

	public HashMapPartHandler(TypedRowProcessor<String> hashKeyHandler,
			 TypedRowProcessor rowProcessor) {
		super(rowProcessor);
		this.hashKeyHandler = hashKeyHandler;
	}

	public Map<String, K> handlePart(ResultSet resultSet, ID id, TypedRowProcessor<ID> indexHandler)
			throws SQLException {
		Map<String, K> resultHashMap = new HashMap<String, K>();
		boolean hasNext = true;

		while (hasNext && id.equals(indexHandler.handle(resultSet))) {
			String key = hashKeyHandler.handle(resultSet);
			resultHashMap.put(key, handle(resultSet));
			hasNext = resultSet.next();
		}
		return resultHashMap;
	}

}
