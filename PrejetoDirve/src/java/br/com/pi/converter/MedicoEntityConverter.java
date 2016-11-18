/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi.converter;

import br.com.pi.modelo.Medico;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PC-Paulo
 */
@FacesConverter("MedicoEntityConverter")
public class MedicoEntityConverter extends EntityConverter<Medico>{

	public MedicoEntityConverter() {
		super(Medico.class);
	}
}
