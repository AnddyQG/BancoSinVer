package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface TransferenciaService {

	public void agregar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public Transferencia buscar(String numero);
	public void borrar(String numero);
	public List<Transferencia> buscarTodos();
	public void realizar(String numeroCuentaOrigen,String numeroCuentaDestino,BigDecimal monto);
	
}
