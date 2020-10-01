package org.example;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static CellProcessor[] getProcessor() {
        final CellProcessor[] processors=new CellProcessor[]{
                new UniqueHashCode(),
                new NotNull(),
                new Optional(),
                new NotNull()
        };
        return processors;
    }
    public static CellProcessor[] writeProcessor(){
        final CellProcessor[] processors = new CellProcessor[] { new UniqueHashCode(), // ID
                new NotNull(),
                new Optional(),
                new Optional()
        };
        return processors;
    }
    public static List<Employee> generateDemoData() {
        List<Employee> emps = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId("1");
        emp.setName("Pankaj Kumar");
        emp.setAge("30");
        Employee emp1 = new Employee();
        emp1.setId("2");
        emp1.setName("David");
        emp1.setCountry("USA");
        Employee emp2 = new Employee();
        emp2.setId("3");
        emp2.setName("Lisa");
        emp2.setAge("20");
        emp2.setCountry("India");

        emps.add(emp);
        emps.add(emp1);
        emps.add(emp2);

        return emps;
    }
}
