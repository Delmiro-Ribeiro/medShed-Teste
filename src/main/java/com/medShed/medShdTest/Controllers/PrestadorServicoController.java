package com.medShed.medShdTest.Controllers;

import com.medShed.medShdTest.entities.PrestadorServico;
import com.medShed.medShdTest.servicos.PrestadorServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestadores")
public class PrestadorServicoController {

    @Autowired
    private PrestadorServicoService prestadorServicoService;

    @PostMapping
    public ResponseEntity<PrestadorServico> criarPrestador(@RequestBody PrestadorServico prestadorServico) {
        PrestadorServico novoPrestador = prestadorServicoService.salvarPrestador(prestadorServico);
        return ResponseEntity.ok(novoPrestador);
    }

    @GetMapping
    public ResponseEntity<List<PrestadorServico>> listarPrestadores() {
        List<PrestadorServico> prestadores = prestadorServicoService.listarTodos();
        return ResponseEntity.ok().body(prestadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorServico> buscarPrestadorPorId(@PathVariable Long id) {
        PrestadorServico prestador = prestadorServicoService.buscarPorId(id);
        return ResponseEntity.ok().body(prestador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPrestador(@PathVariable Long id) {
        prestadorServicoService.deletarPrestador(id);
        return ResponseEntity.noContent().build();
    }
}
