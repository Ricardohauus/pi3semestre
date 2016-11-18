package br.com.pi.dao;

import br.com.pi.modelo.Medico;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class MedicoDAO {

    @Inject
    private EntityManager manager;

    public Medico buscarPeloCodigo(Integer codigo) {
        return manager.find(Medico.class, codigo);
    }

    public List<Medico> buscarMedicos(Medico medico) {
        return manager.createNamedQuery("Medico.buscarMedicos", Medico.class).getResultList();
    

}}
