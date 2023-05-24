package exercice3.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exercice3.LoginBean;

public class LoginDaoImpl implements LoginDao {

    private static final String RESOURCE_NAME = "jdbc/MySqlLogin";

    public Connection createConnection() throws SQLException, NamingException {
        InitialContext ic = new InitialContext();
        Context ctx = (Context) ic.lookup("java:comp/env");
        DataSource ds = (DataSource) ctx.lookup(RESOURCE_NAME);

        return ds.getConnection();
    }

    @Override
    public Boolean isUserValid(LoginBean user) {
        Connection connection = null;
       
        
        try {
            connection = createConnection();
            Statement stat = connection.createStatement();
            String sqlInsert = "SELECT * FROM user";
            connection = createConnection();
            ResultSet rs = stat.executeQuery(sqlInsert);
            while( rs.next())
            {
                if(user.getNom().equals(rs.getString("nom")) && user.getPassword().equals((rs.getString("password"))))
                {
                    return true;
                }
            }
            
        } catch (SQLException e) {
                
           e.printStackTrace();
            System.out.println("Erreur de SQL");
        }
        catch(NamingException e)
        {
            System.out.println("Erreur de connexion");
        }
        return false;
    }

}
