package Oracle.Backend.Service;

import Oracle.Backend.Model.NhaXuatBan;
import Oracle.Backend.Model.PhanLoaiDocGia;
import Oracle.Backend.Repository.NhaXuatBanRepository;
import Oracle.Backend.Repository.PhanLoaiDocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhanLoaiDocGiaService {
    @Autowired
    private PhanLoaiDocGiaRepository repo;

    public List<PhanLoaiDocGia> getAll(){
        return repo.findAll();
    }

    public PhanLoaiDocGia getById(Integer id) {
        Optional<PhanLoaiDocGia> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(PhanLoaiDocGia PhanLoaiDocGia) {
        repo.save(PhanLoaiDocGia);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
