package Oracle.Backend.Service;

import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Repository.TacGiaRepository;
import Oracle.Backend.Repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService {
    @Autowired
    private TaiKhoanRepository repo;

    public List<TaiKhoan> getAll(){
        return repo.findAll();
    }

    public TaiKhoan getById(Integer id) {
        Optional<TaiKhoan> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(TaiKhoan TaiKhoan) {
        repo.save(TaiKhoan);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
