package dao;

import entity.*;
import java.sql.*;
import java.util.logging.*;



public class StudentDAO {
	//for debugging purpose
	/**
	public static void main(String[] args){
		System.out.println("ssss");
		StudentDAO sd = new StudentDAO();
		Student s = sd.retrieveStudent("andy.aw.2014","Tele!@34");
		System.out.println(s.getSmu_email_id());
	}
	*/
	    private static final String TBLNAME = "student";
	
    private void handleSQLException(SQLException ex, String sql, String... parameters) {
        String msg = "Unable to access data; SQL=" + sql + "\n";
        for (String parameter : parameters) {
            msg += "," + parameter;
        }
        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, msg, ex);
        throw new RuntimeException(msg, ex);
    }
    
    public Student retrieveStudent(String emailID, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "";
        Student returnStudent = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();

            sql = "select smu_email_id, tele_id, group_id, password from " + TBLNAME + " where smu_email_id = ? and password = binary?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailID);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            while (rs.next()) {
                String smu_email_id = rs.getString(1);
                String tele_id = rs.getString(2);
                String group_id = rs.getString(3);
                String correctPassword = rs.getString(4);


                returnStudent = new Student(smu_email_id, tele_id, group_id,correctPassword);
            }
            //return resultUser;

        } catch (SQLException ex) {
            handleSQLException(ex, sql, "User={" + returnStudent + "}");
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
        return returnStudent;
    }

}
