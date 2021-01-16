package com.example.demoUni.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;





@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="pass")
	private String pass;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate dtRegjistrimi;
	/*
	 * @Column(name="dtRegjistrimi") private String dtRegjistrimi;
	 */
	
	/*
	 * @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
	 * CascadeType.DETACH,CascadeType.REFRESH},mappedBy="student") private
	 * List<LendeStudent> lendeStudent;
	 */
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(nullable=false, name = "id_dege") private Dega dega;
	 * 
	 * public List<LendeStudent> getLendeStudent() { return lendeStudent; }
	 * 
	 * 
	 * public void setLendeStudent(List<LendeStudent> lendeStudent) {
	 * this.lendeStudent = lendeStudent; }
	 */

	public Student() {}
	

	public Student(long id, String firstname, String lastname, String pass, LocalDate dtRegjistrimi) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pass = pass;
		this.dtRegjistrimi = dtRegjistrimi;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	


	public LocalDate getDtRegjistrimi() {
		return dtRegjistrimi;
	}


	public void setDtRegjistrimi(LocalDate dtRegjistrimi) {
		this.dtRegjistrimi = dtRegjistrimi;
	}

	
	
	
}