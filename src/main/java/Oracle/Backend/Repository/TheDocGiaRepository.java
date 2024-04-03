package Oracle.Backend.Repository;

import Oracle.Backend.Model.TheDocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheDocGiaRepository extends JpaRepository<TheDocGia,Integer> {
}
