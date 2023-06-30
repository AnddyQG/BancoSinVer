package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaRepository;
import com.example.demo.repository.TransferenciaRepository;
import com.example.demo.repository.modelo.Cuenta;
import com.example.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements TransferenciaService{
@Autowired
private TransferenciaRepository repository;
@Autowired
private CuentaRepository cuentaRepository;
@Autowired
@Qualifier("nacional")
private MontoDebitarService debitarService;
@Override
public void agregar(Transferencia transferencia) {
	// TODO Auto-generated method stub
	this.repository.insertar(transferencia);
}

@Override
public void actualizar(Transferencia transferencia) {
	// TODO Auto-generated method stub
	this.repository.actualizar(transferencia);
}

@Override
public Transferencia buscar(String numero) {
	// TODO Auto-generated method stub
	return this.repository.encontrar(numero);
}

@Override
public void borrar(String numero) {
	// TODO Auto-generated method stub
	this.repository.eliminar(numero);
}

@Override
public List<Transferencia> buscarTodos() {
	// TODO Auto-generated method stub
	return this.repository.buscarTodos();
}

@Override
public void realizar(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {
	// TODO Auto-generated method stub
	Cuenta cuentaOrigen = this.cuentaRepository.encontrar(numeroCuentaOrigen);
		BigDecimal saldoOrigen= cuentaOrigen.getSaldo();
		BigDecimal montoDebitar=this.debitarService.calcular(monto);
	System.out.println("Saldo antes de la cuenta origen "+ saldoOrigen);
	if(montoDebitar.compareTo(saldoOrigen)<=0) {
		
		BigDecimal saldoFinalOrigen=saldoOrigen.subtract(montoDebitar);
		System.out.println("Saldo despues " + saldoFinalOrigen);
		
		cuentaOrigen.setSaldo(saldoFinalOrigen);
		this.cuentaRepository.actualizar(cuentaOrigen);
		//destino
		Cuenta cuentaDestino= this.cuentaRepository.encontrar(numeroCuentaDestino);
		BigDecimal saldoDestino=cuentaDestino.getSaldo();
		System.out.println("Saldo antes de la cuenta destino "+ saldoDestino);
		BigDecimal saldoDestinoFinal= saldoDestino.add(monto);
		System.out.println("saldo despues " + saldoDestinoFinal);
		cuentaDestino.setSaldo(saldoDestinoFinal);
		this.cuentaRepository.actualizar(cuentaDestino);
		
		Transferencia transferencia= new Transferencia();
		transferencia.setCuentaDestino(numeroCuentaDestino);
		transferencia.setCuentaOrigen(numeroCuentaOrigen);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		Double num= Math.random();
		transferencia.setNumero(num.toString());
		this.repository.insertar(transferencia);
		
		
	}else {
		System.out.println("Saldo no disponible");
	}
	
	
	
}


}
