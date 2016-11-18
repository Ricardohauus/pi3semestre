/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi.converter;

import br.com.pi.modelo.Paciente;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PC-Paulo
 */
@FacesConverter("PacienteEntityConverter")
public class PacienteEntityConverter extends EntityConverter<Paciente>{

	public PacienteEntityConverter() {
		super(Paciente.class);
	}
}
