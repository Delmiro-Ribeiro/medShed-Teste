package com.medShed.medShdTest.repositories;

import com.medShed.medShdTest.entities.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Long> {
}
