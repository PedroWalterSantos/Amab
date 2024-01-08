/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.ProfessorModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Santos
 */
@ApplicationScoped
@Default

public class ProfessorDaoImplements implements ProfessorDaoInterface {

    @PersistenceContext(unitName = "AmabPU")
    private EntityManager entityManager;

    @Transactional
    @Override
    public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
        try {
            entityManager.persist(professorModel);
            return professorModel;
        } catch (Exception e) {
            e.printStackTrace(); // ou use um framework de logging como o SLF4J
            throw new RuntimeException("Erro ao salvar professor no banco de dados.", e);
        }
    }

    @Transactional
    @Override
    public void alterar(ProfessorModel professorModel) {
        ProfessorModel professorModelMerge = entityManager.merge(professorModel);
        entityManager.persist(professorModelMerge);
    }

  @Override
@Transactional
public void excluirProfessor(ProfessorModel professorModel) {
    ProfessorModel managedProfessor = entityManager.find(ProfessorModel.class, professorModel.getCodigo());
    entityManager.remove(managedProfessor);
}

    @Override
    @SuppressWarnings("unchecked")
    public List<ProfessorModel> getProfessores() {
        // Certifique-se de que a estrutura do ProfessorModel reflete as propriedades retornadas
        Query query = entityManager.createQuery("SELECT p FROM ProfessorModel p");
        return query.getResultList();
    }

}
