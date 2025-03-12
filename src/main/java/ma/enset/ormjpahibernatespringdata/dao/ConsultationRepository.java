package ma.enset.ormjpahibernatespringdata.dao;


import ma.enset.ormjpahibernatespringdata.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
