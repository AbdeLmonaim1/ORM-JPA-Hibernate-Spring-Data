package ma.enset.ormjpahibernatespringdata;

import ma.enset.ormjpahibernatespringdata.dao.PatientRepository;
import ma.enset.ormjpahibernatespringdata.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class OrmJpaHibernateSpringDataApplication {





    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(Patient.builder()
                            .name("Monaim")
                            .dateOfBirth(new Date())
                            .sick(true)
                            .score(26)
                    .build());
            patientRepository.save(Patient.builder()
                    .name("Amine")
                    .dateOfBirth(new Date())
                    .sick(true)
                    .score(11)
                    .build());
            patientRepository.save(Patient.builder()
                    .name("Mouad")
                    .dateOfBirth(new Date())
                    .sick(true)
                    .score(17)
                    .build());

        };
    }
    @Bean
    CommandLineRunner commandLineRunnerInit(PatientRepository patientRepository) {
        return args -> {
            System.out.println("List of all patients");
            patientRepository.findAll().forEach(System.out::println);
            System.out.println("Patient by ID: " + patientRepository.findById(2L).get().toString());
            System.out.println("Patient by name: " + patientRepository.findByName("Monaim").toString());
            System.out.println("Update a patient by ID: ");
            Patient patient = patientRepository.findById(2L).get();
            patient.setScore(100);
            patient.setSick(false);
            patientRepository.save(patient);
            System.out.println("Patient by ID: " + patientRepository.findById(2L).get().toString());
            System.out.println("Delete a patient by ID: ");
            patientRepository.deleteById(3L);
            System.out.println("List of all patients after deletion: ");
            patientRepository.findAll().forEach(System.out::println);
        };

    }
}
