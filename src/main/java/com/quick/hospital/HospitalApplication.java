package com.quick.hospital;

import java.util.Date;
import java.util.stream.Stream;

import com.quick.hospital.entities.Consultation;
import com.quick.hospital.entities.Medecin;
import com.quick.hospital.entities.Patient;
import com.quick.hospital.entities.RendezVous;

import com.quick.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quick.hospital.repositories.ConsultationRepository;
import com.quick.hospital.repositories.MedecinRepository;
import com.quick.hospital.repositories.PatientRepository;
import com.quick.hospital.repositories.RendezVousRepository;

@SpringBootApplication
public class HospitalApplication {
    @Autowired
    private IHospitalService hospitalService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ConsultationRepository consultationRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService hospitalService,
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Zakaria","Younes", "Ghait", "Adil", "Nabil", "Kamal")
                    .forEach( name ->{

                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setScore(0);
                        patient.setMalade(false);
                        patient.setRendezVous(null);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Ismail","Ihab", "Adnan", "Otman")
                    .forEach( name ->{

                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setRendezVous(null);
                        hospitalService.saveMedecin(medecin);

                    });

            Patient p1=patientRepository.findById(1L).orElse(null);
            Medecin m1=medecinRepository.findById(3L).orElse(null);

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDateRendezVous(new Date());
            rendezVous.setPatient(p1);
            rendezVous.setMedecin(m1);
            hospitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous2=rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setPrixConsultation(20);
            consultation.setRapportConsultation(" Rapport de la consultation ....");
            consultation.setRendezVous(rendezVous2);
            hospitalService.saveConsultation(consultation);

        };
    }

}
