package Oracle.Backend.Service;

import Oracle.Backend.Model.PhanLoaiDocGia;
import Oracle.Backend.Model.PhieuMuon;
import Oracle.Backend.Repository.PhanLoaiDocGiaRepository;
import Oracle.Backend.Repository.PhieuMuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuMuonService {
    @Autowired
    private PhieuMuonRepository repo;

    public List<PhieuMuon> getAll(){
        return repo.findAll();
    }

    public PhieuMuon getById(Integer id) {
        Optional<PhieuMuon> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(PhieuMuon PhieuMuon) {
        repo.save(PhieuMuon);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
