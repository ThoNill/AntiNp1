package test;

public class TestResult<K> {
	int nr;

	K object;
	boolean isNull;

	public TestResult(int nr, K object, boolean isNull) {
		super();
		this.nr = nr;
		this.object = object;
		this.isNull = isNull;
	}
}
