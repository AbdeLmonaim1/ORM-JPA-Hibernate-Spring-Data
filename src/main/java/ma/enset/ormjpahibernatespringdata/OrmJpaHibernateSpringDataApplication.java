package ma.enset.ormjpahibernatespringdata;

import ma.enset.ormjpahibernatespringdata.dao.ConsultationRepository;
import ma.enset.ormjpahibernatespringdata.dao.MedecinRepository;
import ma.enset.ormjpahibernatespringdata.dao.PatientRepository;
import ma.enset.ormjpahibernatespringdata.dao.RendezVousRepository;
import ma.enset.ormjpahibernatespringdata.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class OrmJpaHibernateSpringDataApplication {





    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }
    @Bean

	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
      return args -> {
		  Stream.of("Hassan", "Ali", "Sofia").forEach(name ->{
			  Patient patient = new Patient();
			  patient.setName(name);
			  patient.setAge((int)(Math.random()*10));
			  patient.setDateOfBirth(new Date());
			  patient.setSick(Math.random()>0.5?true:false);
			  patientRepository.save(patient);
		  });

		  Stream.of("Nourddein", "Ayoub", "Mustapha").forEach(name ->{
			  Medecin medecin = new Medecin();
			  medecin.setName(name);
			  medecin.setAge((int)(Math.random()*100));
			  medecin.setEmail(name+"@gmail.com");
			  medecin.setSpecialite(Math.random()>0.5?"Cardiology":"Ophtalmology");
			  medecinRepository.save(medecin);
		  });
          Patient patient = patientRepository.findByName("Ali");
		  Medecin medecin = medecinRepository.findByName("Nourddein");
		  RendezVous rendezVous = new RendezVous();
		  rendezVous.setDate(new Date());
		  rendezVous.setStatus(StatusRDV.PENDING);
		  rendezVous.setMedecin(medecin);
		  rendezVous.setPatient(patient);
		  rendezVousRepository.save(rendezVous);
		  RendezVous rendezbyID = rendezVousRepository.findById(1L).get();
		  Consultation consultation = new Consultation();
		  consultation.setConsultationDate(new Date());
		  consultation.setRapport("Rapport de la consultation ....");
		  consultation.setRendezVous(rendezbyID);
		  consultationRepository.save(consultation);
	  };
	}
}
