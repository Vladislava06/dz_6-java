import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class task_6 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ivan", "Ivanov", 45, "Manager");
        Employee emp2 = new Employee("Ivan", "Ivanov", 50, 1000.0, "Manager");
        Employee emp3 = new Employee("Ivan", "Ivanov", 50, 1000.0, "Manager");
        System.out.println(emp1.getFullName());
        emp1.upgrade(emp3.salary);
        System.out.println(emp1.salary);
        System.out.println(emp2.olderThan(emp1));
        System.out.println(emp2.hashCode());
        System.out.println(emp2.equals(emp3));
        System.out.println(emp1.toString());
    }
    public static class Employee {
        private String name;
        private String surname;
        private int age;
        private String jobTitle;
        private double salary;
        public Employee(String name, String surname, int age, double salary, String jobTitle) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
        public Employee(String name, String surname, int age, String jobTitle) {
            this(name, surname, age, 50.0, jobTitle);
        }
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + surname.hashCode();
            result = 31 * result + age;
            result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
            result = 31 * result + Double.hashCode(salary);
            return result;
        }
        @Override
        public String toString() {
            return "Employee{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", salary=" + salary +
                    ", jobTitle='" + jobTitle + '\'' +
                    "age= " + age +
                    ", name= '" + name + '\'' +
                    ", surname= '" + surname + '\'' +
                    ", salary= " + salary +
                    ", jobTitle= '" + jobTitle + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Employee person = (Employee) obj;
            if (age != person.age) {
                return false;
            }
            if (!Objects.equals(name, person.name)) {
                return false;
            }
            if (!Objects.equals(surname, person.surname)) {
                return false;
            }
            if (!Objects.equals(jobTitle, person.jobTitle)) {
                return false;
            }
            return Double.compare(salary, person.salary) == 0;
        }
        void upgrade(double salary) {
            this.salary += salary;
        }
        public boolean olderThan(Employee e) {
            return this.age > e.age;
        }
        public String getFullName(){
            return this.name + " " + this.surname;
        }
    }
}

