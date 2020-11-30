package com.everis.bootCampmvcclass.service;

import java.util.List;

import com.everis.bootCampmvcclass.model.Trabajador;

public interface TrabajadorService {
	
	Trabajador create(Trabajador t);
	List<Trabajador> getAll();
	Trabajador findById(Integer id);
	void deleteByid(Integer id);
	Trabajador update(Trabajador t);
	List<Trabajador> findBySegundoApellidoInformado();
	List<Trabajador> findBySegundoApellidoNoInformado();
	List<Trabajador> findByRangoEdad(int edad1, int edad2);

}
