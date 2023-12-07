import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectorSQL {
    Connection c;
    Statement s;
    public ConnectorSQL(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///quizzer","root","test1234");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}