import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = CSVReader.readEmployeesFromCSV("financial_management_system.csv");
        double hourlyRate = FinancialOperations.getHourlyRateSum(employees);
        System.out.printf("Sum of all departments hourly rate: %.2f \n", hourlyRate);

        double sumSalaryOfFinanceDepartment = FinancialOperations.sumDepartmentSalary(employees, "Finance");
        System.out.printf("Sum salary of Finance department: %.2f \n",sumSalaryOfFinanceDepartment);

        double averageOfSalarySalesDepartment = FinancialOperations.getAverageSalaryByDepartment(employees, "Sales");
        System.out.printf("Average salary of Sales department: %.2f \n", averageOfSalarySalesDepartment);

        double sumOfMarketingHourlyRate = FinancialOperations.sumDepartmentHourlyRate(employees, "Marketing");
        System.out.printf("Sum of hourly rate for Marketing: %.2f \n", sumOfMarketingHourlyRate);

        double averageOfHourlyOfIT = FinancialOperations.getAverageHourlyRateByDepartment(employees, "IT");
        System.out.printf("Average hourly rate of IT department: %.2f \n", averageOfHourlyOfIT);

        Map<String, Double> totalSalaryOfOperations = FinancialOperations.getTotalSalaryByDepartment(employees);
        System.out.printf("Total salary of Operations department: %.2f \n", totalSalaryOfOperations.get("Operations"));

        Map<String, Double> averageSalaryOFSalesDepartment = FinancialOperations.getAverageSalaryByDepartment(employees);
        System.out.printf("Average salary of Sales: %.2f \n", averageSalaryOFSalesDepartment.get("Sales"));

        Map<String, Double> totalHourlyRateOfFinanceDepartment = FinancialOperations.getTotalHourlyRateByDepartment(employees);
        System.out.printf("Total hourly rate of Finance Department: %.2f \n", totalHourlyRateOfFinanceDepartment.get("Finance"));

        Map<String, Double> averageHourlyRateOfHRDepartment = FinancialOperations.getAverageHourlyRateByDepartment(employees);
        System.out.printf("Average hourly rate of HR Department: %.2f \n", averageHourlyRateOfHRDepartment.get("HR"));

        int sumOfEmployeeIDs = FinancialOperations.getSumOfEmployeeIdDigits(employees);
        System.out.printf("Sum of employee IDs: %d \n", sumOfEmployeeIDs);

        List<Employee> hrEmployees = employees.stream()
                .filter(e-> e.getDepartment().equals("HR"))
                .collect(Collectors.toList());
        CSVWriter.writeEmployeesToCSV(hrEmployees, "output_hr_employees.csv");

        List <Employee> salesEmployees = employees.stream()
                .filter(e -> e.getDepartment().equals("Sales"))
                .collect(Collectors.toList());
        CSVWriter.writeEmployeesToCSV(salesEmployees, "output_sales.csv");

        List<Employee> marketingEmployees = employees.stream()
                .filter(e -> e.getDepartment().equals("Marketing"))
                .collect(Collectors.toList());
        CSVWriter.writeEmployeesToCSV(marketingEmployees, "output_marketing.csv");

        List<Employee> operationsEmployees = employees.stream()
                .filter((e -> e.getDepartment().equals("Operations")))
                .collect(Collectors.toList());
        CSVWriter.writeEmployeesToCSV(operationsEmployees, "output_operations.csv");

        List<Employee> itEmployees = employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .collect(Collectors.toList());
        CSVWriter.writeEmployeesToCSV(itEmployees, "output_it.csv");

        List<Employee> financeEmployees = employees.stream()
                .filter((e -> e.getDepartment().equals("Finance")))
                .collect(Collectors.toList());
        CSVWriter.writeEmployeesToCSV(financeEmployees, "output_finance.csv");
    }


}
