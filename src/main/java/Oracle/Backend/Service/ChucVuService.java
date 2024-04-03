package Oracle.Backend.Service;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import Oracle.Backend.Model.ChucVu;
import Oracle.Backend.Repository.ChiTietPhieuMuonRepository;
import Oracle.Backend.Repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuService {
    @Autowired
    private ChucVuRepository repo;

    public List<ChucVu> getAll(){
        return repo.findAll();
    }

    public ChucVu getById(Integer id) {
        Optional<ChucVu> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(ChucVu chucVu) {
        repo.save(chucVu);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
