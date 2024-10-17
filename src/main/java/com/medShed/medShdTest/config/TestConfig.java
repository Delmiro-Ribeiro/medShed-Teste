package com.medShed.medShdTest.config;

import com.medShed.medShdTest.entities.Cliente;
import com.medShed.medShdTest.repositories.ClienteRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente();
        c1.setId((int) 1);
        c1.setNome("fulano");
        c1.setEmail("fulano@gmail.com");
        c1.setSenha("112233");
        c1.setTelefone("9999999999");

        Cliente c2 = new Cliente();
        c1.setId((int) 2);
        c1.setNome("fuddlano");
        c1.setEmail("fuddlano@gmail.com");
        c1.setSenha("118882233");
        c1.setTelefone("9966669999");

        clienteRepository.saveAll(Arrays.asList(c1,c2));

    }
}
