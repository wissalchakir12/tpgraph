package architecture.tpgraphql;

import architecture.tpgraphql.DAO.Genre;

public record EtudiantDTO(
        String nom,
        String prenom,
        Genre genre,
        Int centreId

        )
{}

