import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinancialOperations {
    //public static double getHourlyRateSum(List<Employee> employees) {
    //    double sum = 0;
    //    for (Employee employee : employees) {
    //        sum += employee.getSalary();
    //    }
    //    return sum;
    //}
    //
    public static double getHourlyRateSum(List<Employee> employees) {
        return employees.stream().mapToDouble(employee -> employee.getSalary()).sum();
    }

    public static double sumDepartmentSalary(List<Employee> employees, String department){
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public static double getAverageSalaryByDepartment(List<Employee> employees, String department){
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
    public static double sumDepartmentHourlyRate(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getHourly_rate)
                .sum();
    }
    public static double getAverageHourlyRateByDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getHourly_rate)
                .average()
                .orElse(0.0);
    }

}
