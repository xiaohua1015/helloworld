package cn.isdev.framework.bean;

public class Employee {

    private int id;
    private String empName;
    private Dept dept;
    ;


    public int getId() {
        return id;
    }

    public void setId(int empId) {
        this.id = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                '}';
    }
}
