package Oracle.Backend.Repository;

import Oracle.Backend.Model.DauSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DauSachRepository extends JpaRepository<DauSach,Integer> {
}
