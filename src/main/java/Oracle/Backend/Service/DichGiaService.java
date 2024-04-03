package Oracle.Backend.Service;

import Oracle.Backend.Model.ChucVu;
import Oracle.Backend.Model.DichGia;
import Oracle.Backend.Repository.ChucVuRepository;
import Oracle.Backend.Repository.DichGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichGiaService {
    @Autowired
    private DichGiaRepository repo;

    public List<DichGia> getAll(){
        return repo.findAll();
    }

    public DichGia getById(Integer id) {
        Optional<DichGia> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(DichGia DichGia) {
        repo.save(DichGia);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
