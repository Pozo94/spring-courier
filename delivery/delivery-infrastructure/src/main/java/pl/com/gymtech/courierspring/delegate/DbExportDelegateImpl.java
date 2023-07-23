package pl.com.gymtech.courierspring.delegate;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.api.DbApiDelegate;
import pl.com.gymtech.courierspring.config.FileStorageProperties;
import pl.com.gymtech.courierspring.handler.CsvHandler;

import org.springframework.core.io.Resource;
import pl.com.gymtech.courierspring.service.FileService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service

public class DbExportDelegateImpl implements DbApiDelegate {
    CsvHandler csvHandler;
    private final Path fileStorageLocation;
    private final FileService fileStorageService;
    public DbExportDelegateImpl(CsvHandler csvHandler, FileStorageProperties fileStorageProperties, FileService fileStorageService) {
        this.fileStorageService=fileStorageService;
        this.csvHandler = csvHandler;
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
    }

    @Override
    public ResponseEntity<Void> createDbBackup(String file) {
        try {

            csvHandler.exportDataToCsv(fileStorageLocation.toString()+"\\"+file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Resource> getDbBackup(String file) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(file+".csv");



        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
