package Oracle.Backend.Service;

import Oracle.Backend.Model.ChiTietPhieuThu;
import Oracle.Backend.Repository.ChiTietPhieuThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietPhieuThuService {
    @Autowired
    private ChiTietPhieuThuRepository repo;

    public List<ChiTietPhieuThu> getAll(){
        return repo.findAll();
    }

    public ChiTietPhieuThu getById(Integer id) {
        Optional<ChiTietPhieuThu> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(ChiTietPhieuThu ChiTietPhieuThu) {
        repo.save(ChiTietPhieuThu);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
  public List<ChiTietPhieuThu> getAllByMaPhieuThu(int mapt)
 {
 return repo.findAllByPhieuThuId(mapt);
    }
}
