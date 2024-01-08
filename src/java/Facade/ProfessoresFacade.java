/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Dao.ProfessorDaoInterface;
import Modelo.ProfessorModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessoresFacade {

    @Inject
    private ProfessorDaoInterface professorDaoImplen;

    // Outros métodos e lógica de negócio relacionados aos professores
    // Método para listar todos os professores
    @GET
    public List<ProfessorModel> listarProfessores() {
        return professorDaoImplen.getProfessores();
    }

    @POST
    public ProfessorModel salvarProfessor(ProfessorModel professormodel) {
        return professorDaoImplen.salvarProfessor(professormodel);
    }

    @PUT

    public void alterarProfessor(ProfessorModel professormodel) {
        professorDaoImplen.alterar(professormodel);
    }

    @DELETE
@Path("/{codigoProfessor}")
public void excluirProfessor(@PathParam("codigoProfessor") Integer codigoProfessor) {
    // Lógica para excluir o professor no banco de dados
    ProfessorModel professorModel = new ProfessorModel();
    professorModel.setCodigo(codigoProfessor);
    professorDaoImplen.excluirProfessor(professorModel);
}


}
