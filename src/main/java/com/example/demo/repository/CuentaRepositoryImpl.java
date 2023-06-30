package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cuenta;
@Repository
public class CuentaRepositoryImpl implements CuentaRepository{
private static List<Cuenta> baseCuenta= new ArrayList<>();
	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		baseCuenta.add(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.eliminar(cuenta.getNumero());
		this.insertar(cuenta);
	}

	@Override
	public Cuenta encontrar(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuenta= new Cuenta();
	for(Cuenta cue :baseCuenta) {
		if(numero.equals(cue.getNumero())) {
			cuenta= cue;
		}
	}
		
		return cuenta;
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuenta=this.encontrar(numero);
		baseCuenta.remove(cuenta);
	}

	@Override
	public List<Cuenta> buscarTodos() {
		// TODO Auto-generated method stub
		return baseCuenta;
	}

}
