package com.medShed.medShdTest.servicos;

import com.medShed.medShdTest.entities.PrestadorServico;
import com.medShed.medShdTest.repositories.PrestadorServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrestadorServicoService {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    public PrestadorServico salvarPrestador(PrestadorServico prestadorServico) {
        return prestadorServicoRepository.save(prestadorServico);
    }

    public List<PrestadorServico> listarTodos() {
        return prestadorServicoRepository.findAll();
    }

    public PrestadorServico buscarPorId(Long id) {
        return prestadorServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestador de serviço não encontrado"));
    }

    public void deletarPrestador(Long id) {
        prestadorServicoRepository.deleteById(id);
    }
}
