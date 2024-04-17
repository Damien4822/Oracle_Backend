package Oracle.Backend.Repository;

import Oracle.Backend.Model.PhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuMuonRepository extends JpaRepository<PhieuMuon,Integer> {
    List<PhieuMuon> findAllByDocGiaId(int id);
}
