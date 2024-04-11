package Oracle.Backend.Service;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import Oracle.Backend.Repository.ChiTietPhieuMuonRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietPhieuMuonService {
    @Autowired
    private ChiTietPhieuMuonRepository repo;

    public List<ChiTietPhieuMuon> getAll(){
        return repo.findAll();
    }

    public ChiTietPhieuMuon getById(Integer id) {
        Optional<ChiTietPhieuMuon> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(ChiTietPhieuMuon chiTietPhieuMuon) {
        repo.save(chiTietPhieuMuon);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
    public List<ChiTietPhieuMuon> getAllByMaPhieuMuon(int maphieumuon)
    {
        return repo.findAllByPhieuMuonId(maphieumuon);
   }
}
