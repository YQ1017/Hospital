package com.quick.hospital.service;

import com.quick.hospital.entities.Consultation;
import com.quick.hospital.entities.Medecin;
import com.quick.hospital.entities.Patient;
import com.quick.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
