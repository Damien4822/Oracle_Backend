package Oracle.Backend.Service;

import Oracle.Backend.Model.PhieuPhat;
import Oracle.Backend.Model.PhieuThu;
import Oracle.Backend.Repository.PhieuPhatRepository;
import Oracle.Backend.Repository.PhieuThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuThuService {
    @Autowired
    private PhieuThuRepository repo;

    public List<PhieuThu> getAll(){
        return repo.findAll();
    }

    public PhieuThu getById(Integer id) {
        Optional<PhieuThu> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(PhieuThu PhieuThu) {
        repo.save(PhieuThu);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
