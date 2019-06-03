package akademia.localStorage.controllers;

import akademia.localStorage.model.LocalFile;
import akademia.localStorage.services.LocalFileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static akademia.Configs.Constans.*;


@RestController
public class LocalFileController {

    private LocalFileService localFileService;

    public LocalFileController(LocalFileService localFileService) {
        this.localFileService = localFileService;
    }

    @GetMapping(FILES)
    public List<LocalFile> getFiles() throws IOException {
        return localFileService.getFiles();
    }
/*
    @PostMapping(UPLOAD_PATH) //localhost:8080/api/files/
    // to samo co -> @PostMapping(method = RequestMethod.POST, value = FILES, produces = "applications/json")
    public ResponseEntity<LocalFile> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {

        if (file.getSize() < 10_000_000) {
            return new ResponseEntity<>(localFileService.uploadFile(file), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        }*/

    @PostMapping(UPLOAD_PATH)
    public ResponseEntity<LocalFile> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        if(file.getSize() < 10_000_000L) {
            return new ResponseEntity<>(localFileService.uploadFile(file), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

        @GetMapping(DOWNLOAD_PATH + "{file}")
        public ResponseEntity<?> downloadFile(@PathVariable String file) throws IOException {

        Resource resource = localFileService.downloadFile(file);
            File targetFile = new File(resource.getFile().getAbsolutePath());

            String contentType = Files.probeContentType(Paths.get(resource.getURI()));

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename = \"" + targetFile.getName() + "\"")
                    .contentLength(targetFile.length())
                    .body(resource);

        }

        @DeleteMapping(DELETE_PATH + "{file}")
    public void deleteFile(String fileName){
  localFileService.deleteFile(fileName);

    }
}
