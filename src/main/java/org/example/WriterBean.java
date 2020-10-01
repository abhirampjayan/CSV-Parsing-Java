package org.example;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.example.App.*;

public class WriterBean {
    public static void main(String[] args) throws IOException {
        final List<Employee> employeeList = generateDemoData();
        ICsvBeanWriter beanWriter= null;
        try {
            beanWriter = new CsvBeanWriter(new FileWriter("output.csv"), CsvPreference.STANDARD_PREFERENCE);
            final String[] header = new String[] { "id", "name", "age", "country" };
            final CellProcessor[] processors=writeProcessor();
            beanWriter.writeHeader(header);
            for (Employee emp:employeeList
                 ) {
                beanWriter.write(emp,header,processors);
            }

            StringWriter writer = new StringWriter();
            ICsvBeanWriter beanWriter1 = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
            final CellProcessor[] processors1=writeProcessor();
            beanWriter1.writeHeader(header);
            for (final Employee emp : employeeList) {
                beanWriter1.write(emp, header, processors1);
            }
            beanWriter1.close();
            System.out.println("CSV Data\n" + writer.toString());

        } finally {
            if(beanWriter!=null)
                beanWriter.close();

        }



    }
}
