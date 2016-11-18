/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi.converter;

import br.com.pi.modelo.Medico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PC-Paulo
 */
@FacesConverter("medicoConverter")
public class MedicoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String valor) {
        if (valor.equals("") || !valor.contains("#")) {
            return null;
        }
        Medico medico = new Medico();

        String[] propriedades = valor.split("#");
        if (!propriedades[0].isEmpty()) {
            medico.setId(new Integer(propriedades[0]));
        }
        if (!propriedades[1].isEmpty()) {
            medico.setNome(propriedades[1]);
        }
        if (!propriedades[1].isEmpty()) {
            medico.setCrm(propriedades[1]);
        }

        return medico;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object obj) {
        if (obj == null || !(obj instanceof Medico)) {
            return "";
        }

        Medico medico = (Medico) obj;

        String medicoId = medico.getId()== null ? "" : medico.getId().toString();
        String nome = medico.getNome() == null ? "" : medico.getNome();
        String crm =  medico.getCrm()== null ? "" : medico.getCrm();
        return /*id + "#" +*/ nome;
    }

}
