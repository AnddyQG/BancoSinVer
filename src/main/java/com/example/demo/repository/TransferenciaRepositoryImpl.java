package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Transferencia;
@Repository
public class TransferenciaRepositoryImpl implements TransferenciaRepository{
private static List<Transferencia> baseTransferencia= new ArrayList<>();
	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		baseTransferencia.add(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
	}

	@Override
	public Transferencia encontrar(String numero) {
		// TODO Auto-generated method stub
		Transferencia transferencia= new Transferencia();
		for(Transferencia tran : baseTransferencia) {
			if(numero.equals(tran.getNumero())) {
				transferencia=tran;
			}
		}
		
		return transferencia;
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Transferencia transferencia= this.encontrar(numero);
		baseTransferencia.remove(transferencia);
	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		return baseTransferencia;
	}

}
