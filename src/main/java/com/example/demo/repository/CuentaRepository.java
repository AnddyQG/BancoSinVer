package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Cuenta;

public interface CuentaRepository {

	public void insertar(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public Cuenta encontrar(String numero);
	public void eliminar(String numero);
	public List<Cuenta> buscarTodos();
	
}
