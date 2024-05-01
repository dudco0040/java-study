package prob04;

public class Depart extends Employee {
	private String department;
	
	// 생성자
	Depart(String name, int salary, String department){
		setName(name);
		setSalary(salary);
		setDepartment(department);
	}
	
	// Department 
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment(String department) {
		return department;
	}
	
	// getInformation 구현 오버 라이딩
	public void getInformation() {
//		System.out.println( "이름:" + name + "연봉:" + salary + "부서: " + department); // 안되는 이유 자세히 찾아보고 정리하기
		System.out.println( "이름:" + getName() + " 연봉:" + getSalary() + " 부서:" + department);
	}

}
