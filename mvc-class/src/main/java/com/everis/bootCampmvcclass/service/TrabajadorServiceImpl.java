package com.everis.bootCampmvcclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bootCampmvcclass.model.Trabajador;
import com.everis.bootCampmvcclass.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {
	
	@Autowired
	private TrabajadorRepository trabajadorRepository;

	@Override
	public Trabajador create(Trabajador t) {
		return trabajadorRepository.save(t);
	}
	
	@Override
	public List<Trabajador> getAll() {
		return trabajadorRepository.findAll();
	}

	@Override
	public Trabajador findById(Integer id) {
		return trabajadorRepository.findById(id).get();
	}

	@Override
	public void deleteByid(Integer id) {
		trabajadorRepository.deleteById(id);
	}

	@Override
	public Trabajador update(Trabajador t) {
		return trabajadorRepository.save(t);
	}

	@Override
	public List<Trabajador> findBySegundoApellidoInformado() {
		return trabajadorRepository.findByApellido2NotNull();
	}

	@Override
	public List<Trabajador> findBySegundoApellidoNoInformado() {
		return trabajadorRepository.findByApellido2IsNull();
	}

	@Override
	public List<Trabajador> findByRangoEdad(int edad1, int edad2) {
		return trabajadorRepository.findByEdadBetween(edad1, edad2);
	}

}
