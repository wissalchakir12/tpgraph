package architecture.tpgraphql.Mapping;

import architecture.tpgraphql.DAO.Centre;
import architecture.tpgraphql.DAO.Etudiant;
import architecture.tpgraphql.DTO.EtudiantDTO;
import architecture.tpgraphql.Repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToEtudiant {
    @Autowired
    CentreRepository centreRepository;
    public void toEtudiant(Etudiant et, EtudiantDTO dto) {
        Centre centre=
                centreRepository.findById(dto.centreId()).orElse(null);
        if (dto != null) {
            et.setNom(dto.nom());
            et.setPrenom(dto.prenom());
            et.setGenre(dto.genre());
            et.setCentre(centre);
        }
    }
}