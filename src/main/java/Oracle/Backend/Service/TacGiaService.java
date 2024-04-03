package Oracle.Backend.Service;

import Oracle.Backend.Model.SachDienTu;
import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Repository.SachDienTuRepository;
import Oracle.Backend.Repository.TacGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacGiaService {
    @Autowired
    private TacGiaRepository repo;

    public List<TacGia> getAll(){
        return repo.findAll();
    }

    public TacGia getById(Integer id) {
        Optional<TacGia> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(TacGia TacGia) {
        repo.save(TacGia);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
