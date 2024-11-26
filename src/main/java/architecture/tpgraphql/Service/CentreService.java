package architecture.tpgraphql.Service;

import architecture.tpgraphql.DAO.Centre;
import architecture.tpgraphql.DTO.CentreDTO;
import architecture.tpgraphql.Repository.CentreRepository;
import architecture.tpgraphql.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CentreRepository centreRepository;

    public List<Centre> getCentres() {
        return centreRepository.findAll();
    }
    public Centre getCentre(Integer id) {
        return centreRepository.findById(id).orElse(null);
    }
    public Centre addCentre(CentreDTO centre)
    {
        Centre newCentre = new Centre();
        newCentre.setNom(centre.nom());
        newCentre.setAdresse(centre.adresse());
        return centreRepository.save(newCentre);

    }
    public Centre updateCentre(CentreDTO centreDTO) {
        Centre newCentre = new Centre();
        newCentre.setNom(centreDTO.nom());
        newCentre.setAdresse(centreDTO.adresse());
        return centreRepository.save(newCentre);
    }
    public String deleteCentre(Integer id) {

        centreRepository.deleteById(id);
        return "Centre deleted with id: " + id;

    }
}
