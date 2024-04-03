package Oracle.Backend.Service;

import Oracle.Backend.Model.PhieuThu;
import Oracle.Backend.Model.SachDienTu;
import Oracle.Backend.Repository.PhieuThuRepository;
import Oracle.Backend.Repository.SachDienTuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SachDienTuService {
    @Autowired
    private SachDienTuRepository repo;

    public List<SachDienTu> getAll(){
        return repo.findAll();
    }

    public SachDienTu getById(Integer id) {
        Optional<SachDienTu> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(SachDienTu SachDienTu) {
        repo.save(SachDienTu);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
