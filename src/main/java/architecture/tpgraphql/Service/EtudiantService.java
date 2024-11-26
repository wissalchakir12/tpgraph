package architecture.tpgraphql.Service;

import architecture.tpgraphql.DAO.Centre;
import architecture.tpgraphql.DAO.Etudiant;
import architecture.tpgraphql.DTO.EtudiantDTO;
import architecture.tpgraphql.Repository.CentreRepository;
import architecture.tpgraphql.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CentreRepository centreRepository;


    public List<Etudiant> getStudents() {
        return etudiantRepository.findAll();
    }

    public Etudiant addEtudiant(EtudiantDTO etudiant) {
        Centre centre = centreRepository.findById(etudiant.centreId()).orElse(null);
        if (centre != null) {
            Etudiant et = new Etudiant();
            et.setNom(etudiant.nom());
            et.setPrenom(etudiant.prenom());
            et.setGenre(etudiant.genre());
            et.setCentre(centre);
            etudiantRepository.save(et);

            return et;
        }
        return null;
    }
    public Etudiant updateEtudiant(int id, EtudiantDTO etudiant){
        Centre centre=centreRepository.findById(etudiant.centreId()).orElse(null);
        if(centre!=null)
            if(etudiantRepository.findById(id).isPresent()){
                Etudiant et=etudiantRepository.findById(id).get();
                et.setNom(etudiant.nom());
                et.setPrenom(etudiant.prenom());
                et.setGenre(etudiant.genre());
                et.setCentre(centre);
                return etudiantRepository.save(et);
            }
        return null;
    }

    public String deleteEtudiant(int id){
        if(etudiantRepository.findById(id).isPresent()){
            etudiantRepository.deleteById(id);
            return String.format("l'étudiant %s est bien supprimé !",id);
        }
        return String.format("l'étudiant %s n'existe pas !",id);
    }

    public Etudiant getEtudiant(int id){
        return etudiantRepository.findById(id).orElse(null);
    }

}


