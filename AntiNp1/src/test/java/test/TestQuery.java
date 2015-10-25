package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import antinp1.Query;

public class TestQuery implements Query {
	ResultSet result;

	public TestQuery(ResultSet result) {
		super();
		this.result = result;
	}

	public ResultSet execute() throws SQLException {
		return result;
	}

}
