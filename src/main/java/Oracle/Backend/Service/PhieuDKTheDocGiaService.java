package Oracle.Backend.Service;

import Oracle.Backend.Model.PhanLoaiDocGia;
import Oracle.Backend.Model.PhieuDKTheDocGia;
import Oracle.Backend.Repository.PhanLoaiDocGiaRepository;
import Oracle.Backend.Repository.PhieuDKTheDocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuDKTheDocGiaService {
    @Autowired
    private PhieuDKTheDocGiaRepository repo;

    public List<PhieuDKTheDocGia> getAll(){
        return repo.findAll();
    }

    public PhieuDKTheDocGia getById(Integer id) {
        Optional<PhieuDKTheDocGia> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(PhieuDKTheDocGia PhieuDKTheDocGia) {
        repo.save(PhieuDKTheDocGia);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
