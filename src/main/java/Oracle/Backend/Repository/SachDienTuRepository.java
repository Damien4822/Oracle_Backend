package Oracle.Backend.Repository;

import Oracle.Backend.Model.SachDienTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SachDienTuRepository extends JpaRepository<SachDienTu,Integer> {
}
