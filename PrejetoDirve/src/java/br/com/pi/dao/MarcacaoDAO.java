package br.com.pi.dao;

import br.com.pi.modelo.Horario;
import br.com.pi.modelo.Medico;
import java.util.List;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;


import org.hibernate.criterion.Restrictions;

public class MarcacaoDAO {

    @Inject
    private EntityManager manager;
    public Horario buscarPeloCodigo(Integer codigo){
        return manager.find(Horario.class, codigo);
    }

    @SuppressWarnings("unchecked")
    public List<Horario> buscarHorarios(Medico medico) {
        Session session = this.manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Horario.class);
        if (medico != null) {
            criteria.add(Restrictions.eq("medico", medico));
        }
        return criteria.list();
    }
}
