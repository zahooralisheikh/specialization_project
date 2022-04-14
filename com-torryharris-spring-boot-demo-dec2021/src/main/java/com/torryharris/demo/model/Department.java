package com.torryharris.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;

	private String departmentName;

	private String city;

	public Department() {
		super();
	}

	public Department(String department_name, String city) {
		super();
		this.departmentName = department_name;
		this.city = city;
	}

	public Department(int department_id, String department_name, String city) {
		super();
		this.departmentId = department_id;
		this.departmentName = department_name;
		this.city = city;
	}

	public Department(int departmentId) {
		super();
		this.departmentId = departmentId;

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int department_id) {
		this.departmentId = department_id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String department_name) {
		this.departmentName = department_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + departmentId;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (departmentId != other.departmentId) {
			return false;
		}
		if (departmentName == null) {
			if (other.departmentName != null) {
				return false;
			}
		} else if (!departmentName.equals(other.departmentName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", city=" + city
				+ "]";
	}

}
