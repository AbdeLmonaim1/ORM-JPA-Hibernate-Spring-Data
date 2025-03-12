package ma.enset.ormjpahibernatespringdata.dao;

import ma.enset.ormjpahibernatespringdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
