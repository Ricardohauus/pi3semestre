
package br.com.pi.converter;

import br.com.pi.dao.GenericDAO;
import br.com.pi.modelo.Medico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Medico.class, value="MedicoConverter")
public class MedicoConveter implements Converter {
    


    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {        

        if(value == null || value.isEmpty()){
            return null;
        }else{
            Long medicoId = Long.parseLong(value);
            Medico unidade = new GenericDAO<Medico>(Medico.class).obterPorId(Integer.SIZE);
            return unidade;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        Medico medico = (Medico)value;
        if(medico != null){
            return String.valueOf(medico.getId());
        }else{
            return null;
        }

    }
}
    

