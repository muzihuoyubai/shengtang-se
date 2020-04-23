package club.banyuan.company;

public class Employee {

  public String name;
  public int salary = 8000;
  public int workHours;

  public void setWorkHours(int workHours) {
    this.workHours = workHours;
  }

  public int getSalary() {
    if (workHours > 196) {
      return salary + (workHours - 196) * 200;
    } else {
      return salary;
    }
  }
}
