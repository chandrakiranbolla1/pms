package com.pms.Doctor_service.controller;

import com.pms.Doctor_service.model.Doctor;
import com.pms.Doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not Found"));
    }

    @PostMapping
    public  Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id,@RequestBody Doctor doctorDetails){
        Doctor  doctor  = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("Doctor not Found"));
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setEmail(doctorDetails.getEmail());
        return doctorRepository.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorRepository.deleteById(id);
    }
}

