package student.management.system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private long studentPhoneNo;
	private String studentEmail;
	private double studentFee;
	
	@ManyToOne
	@JoinColumn
	private Admin admin;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public long getStudentPhoneNo() {
		return studentPhoneNo;
	}
	public void setStudentPhoneNo(long studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public double getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(double studentFee) {
		this.studentFee = studentFee;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
