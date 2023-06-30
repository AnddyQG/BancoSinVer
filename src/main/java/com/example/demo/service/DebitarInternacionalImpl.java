package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service("internacional")
public class DebitarInternacionalImpl implements MontoDebitarService{

	@Override
	public BigDecimal calcular(BigDecimal monto) {
		// TODO Auto-generated method stub
		
		BigDecimal debitar= monto.multiply(new BigDecimal(10)).divide(new BigDecimal(100));
		BigDecimal montoFinal= debitar.add(monto);
		
		return montoFinal;
	}

}
