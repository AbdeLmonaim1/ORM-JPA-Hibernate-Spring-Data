package ma.enset.ormjpahibernatespringdata.web;

import lombok.AllArgsConstructor;
import ma.enset.ormjpahibernatespringdata.dao.PatientRepository;
import ma.enset.ormjpahibernatespringdata.entities.Patient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientRestController {
    private PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String listPatient(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patientsList", patients);
        return "Patients";
    }
}
