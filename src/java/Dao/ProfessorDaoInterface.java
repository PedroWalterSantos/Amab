/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Modelo.ProfessorModel;
import java.util.List;

/**
 *
 * @author Santos
 */
public interface ProfessorDaoInterface {
	
	  ProfessorModel salvarProfessor(ProfessorModel professormodel);

          void alterar(ProfessorModel professormodel);

          void excluirProfessor(ProfessorModel professormodel);

          List<ProfessorModel> getProfessores();
}
