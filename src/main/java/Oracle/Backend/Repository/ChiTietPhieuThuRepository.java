package Oracle.Backend.Repository;

import Oracle.Backend.Model.ChiTietPhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietPhieuThuRepository extends JpaRepository<ChiTietPhieuThu,Integer> {
    List<ChiTietPhieuThu> findAllByPhieuThuId(int mapt);
}
