package com.pms.Doctor_service.repository;

import com.pms.Doctor_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
