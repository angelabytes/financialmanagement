import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinancialOperations {
    //public static double getHourlyRateSum(List<Employee> employees) {
    //    double sum = 0;
    //    for (Employee employee : employees) {
    //        sum += employee.getHourlyRate();
    //    }
    //    return sum;
    //}
    //
    public static double getHourlyRateSum(List<Employee> employees) {
        return employees.stream().mapToDouble(employee -> employee.getHourlyRate()).sum();
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
                .mapToDouble(Employee::getHourlyRate)
                .sum();
    }
    public static double getAverageHourlyRateByDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getHourlyRate)
                .average()
                .orElse(0.0);
    }
    public static Map<String, Double> getTotalSalaryByDepartment(List<Employee> employees){
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

    }

    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static Map<String, Double> getTotalHourlyRateByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getHourlyRate)));
    }
    public static Map<String, Double> getAverageHourlyRateByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getHourlyRate)));

    }

    public static int getNumSum(int number) {
        int sum = 0;
        sum += number;
        return sum;
    }


    public static int getSumOfEmployeeIdDigits(List<Employee> employees){
        return employees.stream()
                .mapToInt(Employee::getId)
                .map(FinancialOperations::getNumSum)
                .sum();
    }

}
