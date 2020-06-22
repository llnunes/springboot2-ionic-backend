package com.llnunes.cursomc.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.llnunes.cursomc.domain.PagamentoBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoBoleto(PagamentoBoleto pagto, Date instante) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instante);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());		
	}
	
	public void preencherPagamentoBoleto(PagamentoBoleto pagto, LocalDate instante) {
		instante = instante.plusDays(7);
//		pagto.setDataVencimento(instante);
	}
	

}
