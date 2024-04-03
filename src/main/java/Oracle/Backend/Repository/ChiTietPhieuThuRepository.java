package Oracle.Backend.Repository;

import Oracle.Backend.Model.ChiTietPhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuThuRepository extends JpaRepository<ChiTietPhieuThu,Integer> {
}
