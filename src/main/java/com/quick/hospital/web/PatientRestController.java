package com.quick.hospital.web;

import com.quick.hospital.entities.Consultation;
import com.quick.hospital.entities.Medecin;
import com.quick.hospital.entities.Patient;
import com.quick.hospital.entities.RendezVous;
import com.quick.hospital.repositories.ConsultationRepository;
import com.quick.hospital.repositories.MedecinRepository;
import com.quick.hospital.repositories.PatientRepository;
import com.quick.hospital.repositories.RendezVousRepository;
import com.quick.hospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private IHospitalService iHospitalService;

    @GetMapping("/patients")
    List<Patient> patientList(){
        return patientRepository.findAll();
    }

    @GetMapping("/medecins")
    List<Medecin> medecinList(){
        return medecinRepository.findAll();
    }

    @GetMapping("/rendezVous")
    List<RendezVous> rendezVousList(){
        return rendezVousRepository.findAll();
    }

    @GetMapping("/consultations")
    List<Consultation> consultationList(){
        return consultationRepository.findAll();
    }
}
