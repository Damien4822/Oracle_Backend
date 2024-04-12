package Oracle.Backend.Service;

import Oracle.Backend.Model.PhieuThu;
import Oracle.Backend.Model.QuyenSach;
import Oracle.Backend.Repository.PhieuThuRepository;
import Oracle.Backend.Repository.QuyenSachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuyenSachService {
    @Autowired
    private QuyenSachRepository repo;

    public List<QuyenSach> getAll(){
        return repo.findAll();
    }

    public QuyenSach getById(Integer id) {
        Optional<QuyenSach> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(QuyenSach QuyenSach) {
        repo.save(QuyenSach);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }

    public List<QuyenSach> getAllByMaTinhTrang(int matinhtrang)
    {
        return repo.findAllByTinhTrangSachId(matinhtrang);
    }
    public List<QuyenSach> getAllByMaDauSach(int mads)
    {
        return repo.findAllByDauSachId(mads);
    }
}
