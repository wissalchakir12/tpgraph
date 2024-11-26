package architecture.tpgraphql.DTO;

import architecture.tpgraphql.DAO.Etudiant;
import jakarta.persistence.OneToMany;

import java.util.List;

public record CentreDTO(
         int id,
         String nom,
         String adresse

)
{}
