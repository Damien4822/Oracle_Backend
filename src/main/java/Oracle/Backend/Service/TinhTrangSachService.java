package Oracle.Backend.Service;

import Oracle.Backend.Model.TheDocGia;
import Oracle.Backend.Model.TinhTrangSach;
import Oracle.Backend.Repository.TinhTrangSachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhTrangSachService {
    @Autowired
    private TinhTrangSachRepository repo;

    public List<TinhTrangSach> getAll(){
        return repo.findAll();
    }

    public TinhTrangSach getById(Integer id) {
        Optional<TinhTrangSach> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(TinhTrangSach TinhTrangSach) {
        repo.save(TinhTrangSach);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
