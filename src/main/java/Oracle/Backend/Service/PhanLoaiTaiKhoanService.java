package Oracle.Backend.Service;

import Oracle.Backend.Model.PhanLoaiDocGia;
import Oracle.Backend.Model.PhanLoaiTaiKhoan;
import Oracle.Backend.Repository.PhanLoaiDocGiaRepository;
import Oracle.Backend.Repository.PhanLoaiTaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhanLoaiTaiKhoanService {
    @Autowired
    private PhanLoaiTaiKhoanRepository repo;

    public List<PhanLoaiTaiKhoan> getAll(){
        return repo.findAll();
    }

    public PhanLoaiTaiKhoan getById(Integer id) {
        Optional<PhanLoaiTaiKhoan> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(PhanLoaiTaiKhoan PhanLoaiTaiKhoan) {
        repo.save(PhanLoaiTaiKhoan);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
