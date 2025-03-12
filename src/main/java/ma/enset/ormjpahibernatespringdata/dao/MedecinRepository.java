package ma.enset.ormjpahibernatespringdata.dao;


import ma.enset.ormjpahibernatespringdata.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByName(String name);
}
