package Oracle.Backend.Repository;

import Oracle.Backend.Model.DichGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichGiaRepository extends JpaRepository<DichGia,Integer> {
}
