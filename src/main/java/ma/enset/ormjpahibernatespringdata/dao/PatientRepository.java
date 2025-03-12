package ma.enset.ormjpahibernatespringdata.dao;

import ma.enset.ormjpahibernatespringdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String name);
}
