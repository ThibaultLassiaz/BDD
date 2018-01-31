package airChance;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in 
 Project Properties.
 * To change this template file, choose To
 ols | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author catherineberru t
 */
public class requetesbd {

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *
     * @param conn connexio n � la base de donn � es
     * @throws SQLException en cas d'erreur d'acc � s � la base de donn � es
     */
    public static void nbemp(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM EMP");
        while (rs.next()) {
            System.out.println("Nombre d'employes : " + rs.getInt(1));
        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }
    public static void salaireEtCom(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT sal,comm FROM EMP");
        while (rs.next()) {
            
            System.out.println("Salaire : " + rs.getInt(1));
            System.out.print("Commission : " + rs.getInt(2) + " ");
        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }
    
    public static void manager(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT e1.ename,e2.ename FROM EMP e1 JOIN EMP e2 ON e1.mgr=e2.empno");
        while (rs.next()) {
            
            System.out.println("Nom : " + rs.getString(1));
            System.out.print("Nom Supérieur : " + rs.getString(2) + " ");
        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }
    
    public static void sommeSalaire(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT SUM(sal+nvl(comm,0)) FROM EMP NATURAL JOIN DEPT GROUP BY deptno");
        while (rs.next()) {
            
            System.out.println("Somme Salaire et Commission : " + rs.getString(1));
            
        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }
    
    
    

    public static void
            employes(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
        while (rs.next()) {
            System.out.print("empno : " + rs.getInt(1) + " ");
            System.out.print("nom : " + rs.getString(2) + " ");
            System.out.println("job : " + rs.getString(3));
        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }
}
