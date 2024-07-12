package com.ecan.teste.repository;

import com.ecan.teste.model.BeneficiarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<BeneficiarioModel, Long> {
}
