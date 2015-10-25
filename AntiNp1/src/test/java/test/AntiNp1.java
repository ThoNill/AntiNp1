package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.RowSetMetaDataImpl;

import test.MockResultSet;

import org.junit.After;
import org.junit.Test;

import antinp1.IDinFirstColumn;
import antinp1.PartHandler;
import antinp1.PartIterator;
import antinp1.handler.Column;
import antinp1.handler.ColumnHandler;
import antinp1.handler.ListPartHandler;

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
	
	@Test
	public void test5() throws SQLException {
		RowSetMetaDataImpl metaData = createMetaData();
		ResultSet resultSet = MockResultSet.create(metaData, new Object[][] {
				{ 1, "a11", "a1" }, 
				{ 1, "a12", "a2" }, 
				{ 1, "a13", "a3" }, 
				{ 4, "a41", "a4" } });

		TestQuery query = new TestQuery(resultSet);

		IDinFirstColumn id = new IDinFirstColumn();
	
		
		Column<String> secondColumn  = new Column<String>(2);
		
		ListPartHandler<String,Integer> listHandler = new ListPartHandler<String, Integer>(id,secondColumn );
		
		
		PartIterator<Integer, List<String>> iter = new PartIterator<Integer, List<String>>(
				id, listHandler);

		iter.setQuery(query);

		TestExpected<List<String>> expected = new TestExpected<List<String>>();
		expected.addResult(1, getList("a11","a12","a13"));
		expected.addResult(4, getList("a41"));
		expected.addEmptyResult(5);
		expected.addEmptyResult(6);
		expected.addEmptyResult(7);
		expected.compare(iter);

	}

	private List<String> getList(String... texte) {
		List<String> l = new ArrayList();
		for ( String text : texte) {
			l.add(text);
		}
		return l;
	}
}
