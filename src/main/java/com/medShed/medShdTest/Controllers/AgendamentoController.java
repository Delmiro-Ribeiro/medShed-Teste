package com.medShed.medShdTest.Controllers;

import com.medShed.medShdTest.entities.Agendamento;
import com.medShed.medShdTest.servicos.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.salvarAgendamento(agendamento);
        return ResponseEntity.ok(novoAgendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.listarTodos();
        return ResponseEntity.ok().body(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgendamentoPorId(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok().body(agendamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamentoAtualizado) {
        Agendamento agendamento = agendamentoService.atualizarAgendamento(id, agendamentoAtualizado);
        return ResponseEntity.ok(agendamento);
    }

    @PutMapping("/reagendar/{id}")
    public ResponseEntity<Agendamento> reagendarAgendamento(@PathVariable Long id, @RequestBody LocalDateTime novaDataHora) {
        Agendamento agendamento = agendamentoService.reagendarAgendamento(id, novaDataHora);
        return ResponseEntity.ok(agendamento);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
