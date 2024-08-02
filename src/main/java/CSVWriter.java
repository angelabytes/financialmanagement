import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;

public class CSVWriter {
    public static void writeEmployeesToCSV(List<Employee> employees, String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("id,name,position,department,salary,hourly_rate");
            bw.newLine();
            for (Employee e : employees) {
                bw.write(String.format("%d,%s,%s,%s,%.2f,%.2f",
                        e.getId(),
                        e.getName(),
                        e.getPosition(),
                        e.getDepartment(),
                        e.getSalary(),
                        e.getHourlyRate()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
