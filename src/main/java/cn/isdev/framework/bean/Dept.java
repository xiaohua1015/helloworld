package cn.isdev.framework.bean;

import java.util.HashSet;
import java.util.Set;

public class Dept {

	private int id;
	private String deptName;
	private Set<Employee> emps = new HashSet<Employee>();
	
	public int getId() {
		return id;
	}
	public void setId(int deptId) {
		this.id = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept{" +
				"id=" + id +
				", deptName='" + deptName +
				'}';
	}
}
