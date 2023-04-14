package com.example.banco;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import com.example.banco.model.Cuenta;
import com.example.banco.repository.CuentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInit implements CommandLineRunner {
    @Autowired
    CuentaRepository cuentaRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        cuentaRepository.save(new Cuenta("cuenta1", BigDecimal.valueOf(1000)));
        cuentaRepository.save(new Cuenta("cuenta2", BigDecimal.valueOf(1000)));
        cuentaRepository.save(new Cuenta("cuenta3", BigDecimal.valueOf(1000)));
        
    }
    
}
