package ma.enset.ormjpahibernatespringdata.services;


import ma.enset.ormjpahibernatespringdata.entities.Consultation;
import ma.enset.ormjpahibernatespringdata.entities.Medecin;
import ma.enset.ormjpahibernatespringdata.entities.Patient;
import ma.enset.ormjpahibernatespringdata.entities.RendezVous;

public interface IHospitalServices {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRendezVous(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
     Patient findPatientByName(String name);
    Medecin findMedecinByName(String name);
    RendezVous findRendezVous(Long id);
}
