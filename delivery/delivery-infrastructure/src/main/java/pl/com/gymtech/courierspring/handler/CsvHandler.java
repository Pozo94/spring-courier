package pl.com.gymtech.courierspring.handler;

import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.com.gymtech.courierspring.entity.*;
import pl.com.gymtech.courierspring.repository.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CsvHandler {
    CustomerRepository customerRepository;
    OrderRepository orderRepository;
    DriverRepository driverRepository;
    TrackingRepository trackingRepository;
    ShipmentRepository shipmentRepository;


    public void exportDataToCsv(String csvFilePath) throws IOException {


        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(csvFilePath+".csv"), CSVFormat.DEFAULT)) {
            exportTableToCsv(customerRepository, csvPrinter);
            exportTableToCsv(orderRepository, csvPrinter);
            exportTableToCsv(driverRepository, csvPrinter);
            exportTableToCsv(trackingRepository, csvPrinter);
            exportTableToCsv(shipmentRepository, csvPrinter);

            csvPrinter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private <T> void exportTableToCsv(CrudRepository<T, String> repository, CSVPrinter csvPrinter) throws IOException {
        Iterable<T> entities = repository.findAll();
        if (entities.iterator().hasNext()) {
            T firstEntity = entities.iterator().next();
            csvPrinter.printRecord("Table: " + firstEntity.getClass().getSimpleName());

            List<String> headers = new ArrayList<>();
            for (var property : firstEntity.getClass().getDeclaredFields()) {
                headers.add(property.getName());
            }
            csvPrinter.printRecord(headers);

            for (T entity : entities) {
                List<String> record = new ArrayList<>();
                for (var property : entity.getClass().getDeclaredFields()) {
                    property.setAccessible(true);
                    try {
                        Object value = property.get(entity);
                        record.add(String.valueOf(value));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                csvPrinter.printRecord(record);
            }

            csvPrinter.println();
        }
    }
}
