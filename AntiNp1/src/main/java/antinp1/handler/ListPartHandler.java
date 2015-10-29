package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import antinp1.PartHandler;
import antinp1.rowprocessors.TypedRowProcessor;

public class ListPartHandler<K, ID> extends BeanPartHandlerBasis<ID, K>
		implements PartHandler<ID, List<K>> {

	public ListPartHandler(TypedRowProcessor<ID> indexHandler,
			TypedRowProcessor<K> beanHanlder) {
		super(indexHandler, beanHanlder);
	}

	public List<K> handlePart(ResultSet resultSet, ID id) throws SQLException {
		List<K> resultList = new ArrayList<K>();
		boolean hasNext = true;
		while (hasNext && id.equals(calculateId(resultSet))) {
			resultList.add(handle(resultSet));
			hasNext = resultSet.next();
		}
		return resultList;
	}

}
