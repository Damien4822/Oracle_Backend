package Oracle.Backend.Service;

import Oracle.Backend.Model.DichGia;
import Oracle.Backend.Model.NhanVien;
import Oracle.Backend.Repository.DichGiaRepository;
import Oracle.Backend.Repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository repo;

    public List<NhanVien> getAll(){
        return repo.findAll();
    }

    public NhanVien getById(Integer id) {
        Optional<NhanVien> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(NhanVien NhanVien) {
        repo.save(NhanVien);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
