package Oracle.Backend.Repository;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuMuonRepository  extends JpaRepository<ChiTietPhieuMuon,Integer> {
}
