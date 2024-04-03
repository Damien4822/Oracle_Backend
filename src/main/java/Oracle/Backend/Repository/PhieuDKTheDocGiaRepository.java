package Oracle.Backend.Repository;

import Oracle.Backend.Model.PhieuDKTheDocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuDKTheDocGiaRepository extends JpaRepository<PhieuDKTheDocGia,Integer> {
}
