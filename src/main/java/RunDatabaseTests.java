import java.util.List;
import java.util.Map;

import org.javalite.activejdbc.Base;

public class RunDatabaseTests {
	public static void connectToDatabase() {

		if (!Base.hasConnection()) {
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/testDatabase", "testUser", "password");

			// Turning off transaction auto completion
			// This will not work if multiple connections are used to the database
			// try {
			// Base.connection().setAutoCommit(false);
			// } catch (Exception se) {
			// // ignore exception
			// }
			System.out.println("Connected to database: " + Base.hasConnection());
		}
	}

	public static void main(String[] args) {
		connectToDatabase();
		System.out.println("Table name: " + TestTable.getTableName());
		System.out.println("Rows in table: " + Base.count("testtable"));

		// Add a new line to the table
		TestTable table = new TestTable();
		table.setInteger("number", 123456.00);
		table.setString("name", "First Test Name");
		table.setString("location", "Budapest");
		System.out.println("Data saved: " + table.saveIt());
		System.out.println("Rows in table: " + Base.count("testtable"));

		// Read a specific line
		System.out.println("Id name: " + table.getIdName());
		System.out.println("Id value: " + table.getId().toString());
		System.out.println("Name: " + table.getString("name"));
		System.out.println("Location: " + table.getString("location"));
		System.out.println("Number: " + table.getInteger("number"));
		System.out.println("Data: " + table.getDate("creation_date"));

		// Run a query
		List<Map> people = Base.findAll("select * from testtable where name = ?", "First Test Name");
		for (Map person : people)
			System.out.println(person.get("name"));

	}

}
