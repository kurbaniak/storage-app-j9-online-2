package akademia.dbStorage.controllers;

import akademia.dbStorage.model.DbFile;
import akademia.dbStorage.services.DbFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbFileController {

    @Autowired //nie jest to rekomendowane
    private DbFileService dbFileService;

    //@Autowired, ale nie wymaga adnotacji
    public DbFileController(DbFileService dbFileService) {
        this.dbFileService = dbFileService;
    }

    public List<DbFile> getFiles(){
        return dbFileService.getFiles();
    }
}
