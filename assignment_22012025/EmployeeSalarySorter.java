package emp.comparator;
import java.util.Comparator;
import emp.assignment.Employee;
public class EmployeeSalarySorter implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2){
		return Float.compare(e1.getSalary(), e2.getSalary());
	}
}