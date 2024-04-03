package Oracle.Backend.Service;

import Oracle.Backend.Model.PhieuDKTheDocGia;
import Oracle.Backend.Model.PhieuPhat;
import Oracle.Backend.Repository.PhieuDKTheDocGiaRepository;
import Oracle.Backend.Repository.PhieuPhatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuPhatService {
    @Autowired
    private PhieuPhatRepository repo;

    public List<PhieuPhat> getAll(){
        return repo.findAll();
    }

    public PhieuPhat getById(Integer id) {
        Optional<PhieuPhat> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(PhieuPhat PhieuPhat) {
        repo.save(PhieuPhat);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
