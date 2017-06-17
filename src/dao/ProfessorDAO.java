package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.*;


public class ProfessorDAO {
		private static final String TBLNAME = "professor";
		
	    private void handleSQLException(SQLException ex, String sql, String... parameters) {
	        String msg = "Unable to access data; SQL=" + sql + "\n";
	        for (String parameter : parameters) {
	            msg += "," + parameter;
	        }
	        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, msg, ex);
	        throw new RuntimeException(msg, ex);
	    }
	    
	    public Professor retrieveProfessor(String emailID, String password) {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        String sql = "";
	        Professor returnProfessor = null;
	        ResultSet rs = null;

	        try {
	            conn = ConnectionManager.getConnection();

	            sql = "select prof_smu_email, password from " + TBLNAME + " where prof_smu_email = ? and password = binary?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, emailID);
	            stmt.setString(2, password);

	            rs = stmt.executeQuery();

	            while (rs.next()) {
	                String prof_smu_email = rs.getString(1);
	                String correctPassword = rs.getString(2);
	             


	                returnProfessor = new Professor(prof_smu_email,correctPassword);
	            }
	            //return resultUser;

	        } catch (SQLException ex) {
	            handleSQLException(ex, sql, "User={" + returnProfessor + "}");
	        } finally {
	            ConnectionManager.close(conn, stmt, rs);
	        }
	        return returnProfessor;
	    }


}
