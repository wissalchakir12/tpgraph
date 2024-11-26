package architecture.tpgraphql.DTO;

import architecture.tpgraphql.DAO.Genre;

public record EtudiantDTO(
        String nom,
        String prenom,
        Genre genre,
        int centreId

        )
{}

