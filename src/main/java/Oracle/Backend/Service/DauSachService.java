package Oracle.Backend.Service;

import Oracle.Backend.Model.ChucVu;
import Oracle.Backend.Model.DauSach;
import Oracle.Backend.Repository.ChucVuRepository;
import Oracle.Backend.Repository.DauSachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DauSachService {
    @Autowired
    private DauSachRepository repo;

    public List<DauSach> getAll(){
        return repo.findAll();
    }

    public DauSach getById(Integer id) {
        Optional<DauSach > optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(DauSach DauSach) {
        repo.save(DauSach);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
