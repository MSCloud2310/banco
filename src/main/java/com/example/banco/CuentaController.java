package com.example.banco;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import com.example.banco.model.Cuenta;
import com.example.banco.repository.CuentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/{id}/retirar/{cantidad}")
    @Transactional
    public BigDecimal retirar(@PathVariable Long id, @PathVariable BigDecimal cantidad) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow();


        BigDecimal saldo = cuenta.getSaldo();
        saldo = saldo.subtract(cantidad);

        cuenta.setSaldo(saldo);
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    
    @GetMapping("/{id}/abonar/{cantidad}")
    @Transactional
    public BigDecimal abonar(@PathVariable Long id, @PathVariable BigDecimal cantidad) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow();

        BigDecimal saldo = cuenta.getSaldo();
        saldo = saldo.add(cantidad);

        cuenta.setSaldo(saldo);
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    @GetMapping("/{id}/saldo")
    @Transactional
    public BigDecimal saldo(@PathVariable Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow();
        return cuenta.getSaldo();
    }
}
