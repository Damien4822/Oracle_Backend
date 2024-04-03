package Oracle.Backend.Repository;

import Oracle.Backend.Model.PhanLoaiDocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanLoaiDocGiaRepository extends JpaRepository<PhanLoaiDocGia,Integer> {
}
