package com.medShed.medShdTest.servicos;

import com.medShed.medShdTest.entities.Agendamento;
import com.medShed.medShdTest.entities.enums.StatusServico;
import com.medShed.medShdTest.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public void deletarAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }


    public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoAtualizado) {
        Agendamento agendamentoExistente = buscarPorId(id);
        agendamentoExistente.setDataHora(agendamentoAtualizado.getDataHora());
        agendamentoExistente.setStatus(agendamentoAtualizado.getStatus());
        agendamentoExistente.setCliente(agendamentoAtualizado.getCliente());
        agendamentoExistente.setPrestadorServico(agendamentoAtualizado.getPrestadorServico());
        agendamentoExistente.setServico(agendamentoAtualizado.getServico());
        return agendamentoRepository.save(agendamentoExistente);
    }

    // Método para reagendar
    public Agendamento reagendarAgendamento(Long id, LocalDateTime novaDataHora) {
        Agendamento agendamentoExistente = buscarPorId(id);
        agendamentoExistente.setDataHora(novaDataHora);
        // Você pode definir a lógica para atualizar o status, se necessário
        agendamentoExistente.setStatus(StatusServico.REAGENDADO);
        return agendamentoRepository.save(agendamentoExistente);
    }

}
