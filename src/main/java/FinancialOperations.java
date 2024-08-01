import java.util.List;

public class FinancialOperations {
    //public static double getHourlyRateSum(List<Employee> employees) {
    //    double sum = 0;
    //    for (Employee employee : employees) {
    //        sum += employee.getSalary();
    //    }
    //    return sum;
    //}
    //
    public static double getMonthlyRateSum(List<Employee> employees) {
        return employees.stream().mapToDouble(employee -> employee.getSalary()).sum();
    }
    public static double sumDepartmentSalary(List<Employee> employees, String department){
        return employees.stream().filter(e -> {e.getDepartment()).equals(department)}

    }
}
