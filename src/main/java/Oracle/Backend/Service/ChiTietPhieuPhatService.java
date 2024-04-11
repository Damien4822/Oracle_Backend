package Oracle.Backend.Service;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import Oracle.Backend.Model.ChiTietPhieuPhat;
import Oracle.Backend.Repository.ChiTietPhieuMuonRepository;
import Oracle.Backend.Repository.ChiTietPhieuPhatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietPhieuPhatService {
    @Autowired
    private ChiTietPhieuPhatRepository repo;

    public List<ChiTietPhieuPhat> getAll(){
        return repo.findAll();
    }

    public ChiTietPhieuPhat getById(Integer id) {
        Optional<ChiTietPhieuPhat> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(ChiTietPhieuPhat ChiTietPhieuPhat) {
        repo.save(ChiTietPhieuPhat);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
 public List<ChiTietPhieuPhat> getAllByMaPhieuPhat(Integer mapp)
 {
       return repo.getAllByPhieuPhatId(mapp);
    }
}
