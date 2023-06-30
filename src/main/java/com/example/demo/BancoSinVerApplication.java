package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Cuenta;
import com.example.demo.service.CuentaService;
import com.example.demo.service.TransferenciaService;

@SpringBootApplication
public class BancoSinVerApplication implements CommandLineRunner{
@Autowired
private CuentaService cuentaService;
@Autowired
private TransferenciaService service;
	public static void main(String[] args) {
		SpringApplication.run(BancoSinVerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Cuenta cuenta1= new Cuenta();
		cuenta1.setNumero("1721");
		cuenta1.setSaldo(new BigDecimal(900));
		cuenta1.setTipo("A");
		cuenta1.setTitular("Anddy");
		
		this.cuentaService.agregar(cuenta1);
		

		Cuenta cuenta2= new Cuenta();
		cuenta2.setNumero("3050");
		cuenta2.setSaldo(new BigDecimal(9500));
		cuenta2.setTipo("A");
		cuenta2.setTitular("Juliana");
		
		this.cuentaService.agregar(cuenta2);
		
		
		this.cuentaService.buscarTodos().forEach(System.out:: println);
		
		this.service.realizar(cuenta1.getNumero(), cuenta2.getNumero(), new BigDecimal(100));
		
		this.service.buscarTodos().stream().forEach(System.out::println);
		
		
		
		
	}

}
