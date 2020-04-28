package club.banyuan.company;

public class Company {

  private int count = 0;
  public Employee[] employeeList = new Employee[10];

  public void add(Employee employee) {
    employeeList[count++] = employee;
  }

  public void delete(String name) {
    for (int i = 0; i < count; i++) {
      if (employeeList[i].name.equals(name)) {
        for (int j = i; j < count - 1; j++) {
          employeeList[j] = employeeList[j + 1];
        }
        count--;
      }
    }
  }

  public void printEmployeeSalary(String name) {
    for (int i = 0; i < count; i++) {
      if (employeeList[i].name.equals(name)) {
        System.out.println(name + "员工工资为:" + employeeList[i].salary);
      }
    }
  }

  public void printTotalSalary() {
    int total = 0;
    for (int i = 0; i < count; i++) {
      total += employeeList[i].getSalary();
    }
    System.out.printf("共有%d为员工，总共需要支付工资为:%d\n", count, total);
  }
}
