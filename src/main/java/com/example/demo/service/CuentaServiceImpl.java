package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaRepository;
import com.example.demo.repository.modelo.Cuenta;
@Service
public class CuentaServiceImpl implements CuentaService{
@Autowired
private CuentaRepository cuentaRepository;
	@Override
	public void agregar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.cuentaRepository.insertar(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.cuentaRepository.actualizar(cuenta);
	}

	@Override
	public Cuenta buscar(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaRepository.encontrar(numero);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.cuentaRepository.eliminar(numero);
	}

	@Override
	public List<Cuenta> buscarTodos() {
		// TODO Auto-generated method stub
		return this.cuentaRepository.buscarTodos();
	}

}
