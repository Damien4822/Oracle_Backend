package Oracle.Backend.Service;

import Oracle.Backend.Model.ChucVu;
import Oracle.Backend.Model.NhaXuatBan;
import Oracle.Backend.Repository.ChucVuRepository;
import Oracle.Backend.Repository.NhaXuatBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaXuatBanService {
    @Autowired
    private NhaXuatBanRepository repo;

    public List<NhaXuatBan> getAll(){
        return repo.findAll();
    }

    public NhaXuatBan getById(Integer id) {
        Optional<NhaXuatBan> optional =repo.findById(id);
        return optional.orElse(null);
    }
    public void save(NhaXuatBan NhaXuatBan) {
        repo.save(NhaXuatBan);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
