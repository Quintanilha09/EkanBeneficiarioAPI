package com.ecan.teste.repository;

import com.ecan.teste.model.BeneficiarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeneficiarioRepository extends JpaRepository<BeneficiarioModel, UUID> {
}
