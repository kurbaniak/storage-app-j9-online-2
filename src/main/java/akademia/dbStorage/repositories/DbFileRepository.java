package akademia.dbStorage.repositories;


import akademia.dbStorage.model.DbFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //dostarcza min odpowiednie logowanie błędów
public interface DbFileRepository extends JpaRepository<DbFile, Long> {


}
