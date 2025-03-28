package com.javamarchhex.main.model;

public class Employee
/* Here only thing we want to declare the variables as per the db table contains
 * Then you can generate the constructors & getters & setters*/
{
	
	private int empid;
	private String empname;
	private String branch;
	private String department;
	private double salary;
	private Address address;// This is a refernece and foreign key present in eployee table
	
	public Employee() // this is the default constructor
	{
		super();
		// TODO Auto-generated constructor stub
	}

	// This is the initialization constructor with id 
	public Employee(int empid, String empname, String branch, String department, double salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.branch = branch;
		this.department = department;
		this.salary = salary;
	}
	
	//This is the initialization constructor without id field
	public Employee(String empname, String branch, String department, double salary) {
		super();
		this.empname = empname;
		this.branch = branch;
		this.department = department;
		this.salary = salary;
	}
	public Employee(int empid, String empname, String branch, String department, 
			double salary, Address address) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.branch = branch;
		this.department = department;
		this.salary = salary;
		this.address = address;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", branch=" + branch + ", department=" + department
				+ ", salary=" + salary + ", address=" + address + "]";
	}

}
