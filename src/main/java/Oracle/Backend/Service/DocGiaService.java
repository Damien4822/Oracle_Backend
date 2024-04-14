package Oracle.Backend.Service;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Repository.DocGiaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DocGiaService {
    @Autowired
    private DocGiaRepository repo;

    public List<DocGia> getAll(){
        return repo.findAll();
    }

    public DocGia getById(Integer id) {
        Optional<DocGia> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(DocGia DocGia) {
        repo.save(DocGia);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
    public DocGia getByTaiKhoan(Optional<TaiKhoan> tk) {
        DocGia optional =repo.findDocGiaByTaiKhoan(tk);
        return optional;
    }
}
