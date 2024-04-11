package Oracle.Backend.Service;

import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Model.TheDocGia;
import Oracle.Backend.Repository.TaiKhoanRepository;
import Oracle.Backend.Repository.TheDocGiaRepository;
import oracle.jdbc.proxy._Proxy_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheDocGiaService {
    @Autowired
    private TheDocGiaRepository repo;

    public List<TheDocGia> getAll(){
        return repo.findAll();
    }

    public TheDocGia getById(Integer id) {
        Optional<TheDocGia> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(TheDocGia TheDocGia) {
        repo.save(TheDocGia);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
   public List<TheDocGia> getAllByMaDocGia(Integer madocgia)
   {

      return repo.findAllByDocGiaId(madocgia);
   }
}
