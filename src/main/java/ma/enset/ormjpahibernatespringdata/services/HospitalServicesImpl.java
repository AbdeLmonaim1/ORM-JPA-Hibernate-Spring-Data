package ma.enset.ormjpahibernatespringdata.services;


import ma.enset.ormjpahibernatespringdata.dao.ConsultationRepository;
import ma.enset.ormjpahibernatespringdata.dao.MedecinRepository;
import ma.enset.ormjpahibernatespringdata.dao.PatientRepository;
import ma.enset.ormjpahibernatespringdata.dao.RendezVousRepository;
import ma.enset.ormjpahibernatespringdata.entities.Consultation;
import ma.enset.ormjpahibernatespringdata.entities.Medecin;
import ma.enset.ormjpahibernatespringdata.entities.Patient;
import ma.enset.ormjpahibernatespringdata.entities.RendezVous;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HospitalServicesImpl implements IHospitalServices{

    private PatientRepository patientRepository;

    private MedecinRepository medecinRepository;

    private RendezVousRepository rendezVousRepository;

    private ConsultationRepository consultationRepository;

    public HospitalServicesImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findPatientByName(String name) {
        Patient patient = patientRepository.findByName(name);
        return patient;
    }

    @Override
    public Medecin findMedecinByName(String name) {
        Medecin medecin = medecinRepository.findByName(name);
        return medecin;
    }

    @Override
    public RendezVous findRendezVous(Long id) {
        RendezVous rendezVous = rendezVousRepository.findById(id).get();
        return rendezVous;
    }
}
