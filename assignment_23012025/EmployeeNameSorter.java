package emp.comparator;
import java.util.Comparator;
import emp.assignment.Employee;
public class EmployeeNameSorter implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2){
		return e1.getName().compareToIgnoreCase(e2.getName());
	}
}