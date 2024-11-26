package architecture.tpgraphql.Repository;

import architecture.tpgraphql.DAO.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Integer> {
}
