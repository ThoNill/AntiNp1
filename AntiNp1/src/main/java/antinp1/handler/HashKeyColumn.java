package antinp1.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;

public class HashKeyColumn implements ResultSetHandler<String> {
	private int id;
	
	public HashKeyColumn(int id) {
		super();
		this.id = id;
	}

	public String handle(ResultSet rs) throws SQLException {
		return rs.getString(id);
	}

	

}
