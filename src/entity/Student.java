package entity;

/**
 * @author User
 *
 */
public class Student {
    private String smu_email_id;
    private String tele_id;
    private String group_id;
    private String password;
    

	public Student(String smu_email_id, String tele_id, String group_id,String password) {
		this.smu_email_id = smu_email_id;
		this.tele_id = tele_id;
		this.group_id = group_id;
		this.password = password;
	}


	public String getSmu_email_id() {
		return smu_email_id;
	}


	public String getTele_id() {
		return tele_id;
	}


	public String getGroup_id() {
		return group_id;
	}


	public String getPassword() {
		return password;
	}



}
