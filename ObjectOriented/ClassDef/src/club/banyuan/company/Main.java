package club.banyuan.company;

public class Main {

  public static void main(String[] args) {
    Company company = new Company();
    Employee e1 = new Employee();
    e1.setWorkHours(205);
    e1.name = "e1";

    Employee e2 = new Employee();
    e2.setWorkHours(220);
    e2.name = "e2";

    Employee e3 = new Employee();
    e3.setWorkHours(180);
    e3.name = "e3";

    Employee e4 = new Employee();
    e4.setWorkHours(196);
    e4.name = "e4";

    company.add(e1);
    company.add(e2);
    company.add(e3);
    company.add(e4);

    company.printTotalSalary();

    company.delete("e3");
    company.printTotalSalary();
  }
}
