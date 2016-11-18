/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi.converter;

import br.com.pi.modelo.Atendimento;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PC-Paulo
 */
@FacesConverter("AtendimentoEntityConverter")
public class AtendimentoEntityConverter extends EntityConverter<Atendimento>{

	public AtendimentoEntityConverter() {
		super(Atendimento.class);
	}
}
