package ch22.test;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
   Tests a database installation by creating and querying
   a sample table. Call this program as
   java -classpath driver_class_path;. TestDB database.properties
*/
public class TestDB 
{
   public static void main(String[] args) throws Exception
   {   
      if (args.length == 0)
      {   
         System.out.println(
               "Usage: java -classpath driver_class_path" 
               + File.pathSeparator 
               + ". TestDB database.properties");
         return;
      }
      else 
         SimpleDataSource.init(args[0]);
      
      Connection conn = SimpleDataSource.getConnection();
      try
      {
         Statement stat = conn.createStatement();

         stat.execute("CREATE TABLE Test (Name CHAR(20))");
         stat.execute("INSERT INTO Test VALUES ('Romeo')");

         ResultSet result = stat.executeQuery("SELECT * FROM Test");
         result.next();
         System.out.println(result.getString("Name"));

         stat.execute("DROP TABLE Test");
      }
      finally
      {
         conn.close();
      }
   }
}
