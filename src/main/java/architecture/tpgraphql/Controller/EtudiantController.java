package architecture.tpgraphql.Controller;

import architecture.tpgraphql.DAO.Centre;
import architecture.tpgraphql.DAO.Etudiant;
import architecture.tpgraphql.DAO.Genre;
import architecture.tpgraphql.DTO.EtudiantDTO;
import architecture.tpgraphql.Repository.CentreRepository;
import architecture.tpgraphql.Repository.EtudiantRepository;
import architecture.tpgraphql.Service.CentreService;
import architecture.tpgraphql.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Controller
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    CentreService centreService;

    @QueryMapping("listEtudiants")
    public List<Etudiant>getAllEtudiants() {
        return etudiantService.getStudents();
    }
    @QueryMapping
    public Etudiant getEtudiantById(@Argument int id){
        return etudiantService.getEtudiant(id);
    }
    @MutationMapping
    public Etudiant addEtudiant(@Argument EtudiantDTO etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }
    @MutationMapping
    public String deleteEtudiant(@Argument int id){
        return etudiantService.deleteEtudiant(id);
    }
    @MutationMapping
    public Etudiant updateEtudiant(@Argument int id,@Argument EtudiantDTO etudiant){
        return etudiantService.updateEtudiant(id,etudiant);
    }

    @SubscriptionMapping
    public Flux<Etudiant> etudiantAdded() {
        return etudiantService.getEtudiantAddedPublisher();
    }

}
