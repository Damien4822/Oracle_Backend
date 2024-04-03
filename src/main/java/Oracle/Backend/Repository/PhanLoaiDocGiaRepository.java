package Oracle.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanLoaiDocGiaRepository extends JpaRepository<PhanLoaiDocGiaRepository,Integer> {
}
