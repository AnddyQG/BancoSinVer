package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Cuenta;

public interface CuentaService {

	public void agregar(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public Cuenta buscar(String numero);
	public void borrar(String numero);
	public List<Cuenta> buscarTodos();
	
}
