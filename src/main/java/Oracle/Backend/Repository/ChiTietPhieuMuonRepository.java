package Oracle.Backend.Repository;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietPhieuMuonRepository  extends JpaRepository<ChiTietPhieuMuon,Integer> {
    List<ChiTietPhieuMuon> findAllByPhieuMuonId(int maphieumuon);
}
