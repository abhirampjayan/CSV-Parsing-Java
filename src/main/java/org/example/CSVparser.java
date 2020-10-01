package org.example;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.example.App.*;

public class CSVparser {
    public static void main(String[] args) throws Exception {
        List<Employee> employeeList=new ArrayList<>();
        ICsvBeanReader beanReader=new CsvBeanReader(new FileReader("employees.csv"), CsvPreference.STANDARD_PREFERENCE);
        final String[] nameMap=new String[]{"id","name","age","country"};
        final CellProcessor[] processors=getProcessor();
        Employee employee;
        while ((employee=beanReader.read(Employee.class,nameMap,processors))!=null){
            employeeList.add(employee);
        }
        System.out.println(employeeList);
        beanReader.close();


    }


}
