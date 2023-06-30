package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface TransferenciaRepository {
 
	
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public Transferencia encontrar(String numero);
	public void eliminar(String numero);
	public List<Transferencia> buscarTodos();
	
}
