package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.rowset.RowSetMetaDataImpl;

import test.MockResultSet;
import org.junit.After;
import org.junit.Test;
import antinp1.IDinFirstColumn;
import antinp1.PartHandler;
import antinp1.PartIterator;
import antinp1.handler.ColumnHandler;

public class AntiNp1 {

	@After
	public void tearDown() throws Exception {
	}

	protected RowSetMetaDataImpl createMetaData() throws SQLException {
		RowSetMetaDataImpl metaData = new RowSetMetaDataImpl();
		metaData.setColumnCount(3);
		metaData.setColumnName(1, "id");
		metaData.setColumnType(1, Types.INTEGER);
		metaData.setColumnName(2, "hashvalue");
		metaData.setColumnType(2, Types.CHAR);
		metaData.setColumnName(3, "value");
		metaData.setColumnType(3, Types.CHAR);
		return metaData;
	}

	@Test
	public void test1() throws SQLException {
		RowSetMetaDataImpl metaData = createMetaData();
		ResultSet resultSet = MockResultSet.create(metaData, new Object[][] {
				{ 1, "a1", "a1" }, { 2, "a2", "a2" } });

		TestQuery query = new TestQuery(resultSet);

		IDinFirstColumn id = new IDinFirstColumn();
		PartHandler<Integer, String> secondColumn = new ColumnHandler<Integer, String>(
				2);
		PartIterator<Integer, String> iter = new PartIterator<Integer, String>(
				id, secondColumn);

		iter.setQuery(query);

		TestExpected<String> expected = new TestExpected<String>();
		expected.addResult(1, "a1");
		expected.addResult(2, "a2");
		expected.compare(iter);

	}

	@Test
	public void test2() throws SQLException {
		RowSetMetaDataImpl metaData = createMetaData();
		ResultSet resultSet = MockResultSet.create(metaData, new Object[][] {
				{ 1, "a1", "a1" }, { 3, "a2", "a2" } });

		TestQuery query = new TestQuery(resultSet);

		IDinFirstColumn id = new IDinFirstColumn();
		PartHandler<Integer, String> secondColumn = new ColumnHandler<Integer, String>(
				2);
		PartIterator<Integer, String> iter = new PartIterator<Integer, String>(
				id, secondColumn);

		iter.setQuery(query);

		TestExpected<String> expected = new TestExpected<String>();
		expected.addResult(1, "a1");
		expected.addEmptyResult(2);
		expected.addResult(3, "a2");
		expected.compare(iter);

	}

	@Test
	public void test3() throws SQLException {
		RowSetMetaDataImpl metaData = createMetaData();
		ResultSet resultSet = MockResultSet.create(metaData, new Object[][] {
				{ 1, "a1", "a1" }, { 4, "a2", "a2" } });

		TestQuery query = new TestQuery(resultSet);

		IDinFirstColumn id = new IDinFirstColumn();
		PartHandler<Integer, String> secondColumn = new ColumnHandler<Integer, String>(
				2);
		PartIterator<Integer, String> iter = new PartIterator<Integer, String>(
				id, secondColumn);

		iter.setQuery(query);

		TestExpected<String> expected = new TestExpected<String>();
		expected.addResult(1, "a1");
		expected.addEmptyResult(2);
		expected.addEmptyResult(3);
		expected.addResult(4, "a2");
		expected.addEmptyResult(5);
		expected.addEmptyResult(6);
		expected.addEmptyResult(7);
		expected.compare(iter);

	}

	@Test
	public void test4() throws SQLException {
		RowSetMetaDataImpl metaData = createMetaData();
		ResultSet resultSet = MockResultSet.create(metaData, new Object[][] {
				{ 1, "a1", "a1" }, { 4, "a2", "a2" } });

		TestQuery query = new TestQuery(resultSet);

		IDinFirstColumn id = new IDinFirstColumn();
		PartHandler<Integer, String> secondColumn = new ColumnHandler<Integer, String>(
				2);
		PartIterator<Integer, String> iter = new PartIterator<Integer, String>(
				id, secondColumn);

		iter.setQuery(query);

		TestExpected<String> expected = new TestExpected<String>();
		expected.addResult(1, "a1");
		expected.addResult(4, "a2");
		expected.addEmptyResult(5);
		expected.addEmptyResult(6);
		expected.addEmptyResult(7);
		expected.compare(iter);

	}
}
