package com.everis.bootCampmvcclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.everis.bootCampmvcclass.model.Trabajador;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
	
	//@Query("select t from Trabajador t where t.apellido2 is not null")
	List<Trabajador> findByApellido2NotNull();
	
	//@Query("select t from Trabajador t where t.apellido2 is null")
	List<Trabajador> findByApellido2IsNull();
	
	//@Query("select t from Trabajador t where t.edad BETWEEN :edad1 and :edad2")
	List<Trabajador> findByEdadBetween(int edad1, int edad2);

}
