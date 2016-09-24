package test;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Assert;

import antinp1.PartIterator;

public class TestExpected<K> extends ArrayList<TestResult<K>> {

	static final String NULL = "null";

	public void addResult(int nr, K object) {
		add(new TestResult<K>(nr, object, object == null));
	}

	public void addEmptyResult(int nr) {
		addResult(nr, null);
	}

	public void compare(PartIterator<Integer, K> iter) throws SQLException {
		for (TestResult r : this) {
			K o = iter.getObjectWithId(r.nr);
			if (r.isNull) {
				Assert.assertNull(o);
			} else {
				Assert.assertEquals(r.object, o);
			}
		}

	}

}
