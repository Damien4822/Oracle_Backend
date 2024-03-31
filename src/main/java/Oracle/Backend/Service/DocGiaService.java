package Oracle.Backend.Service;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Repository.DocGiaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DocGiaService {
    @Autowired
    public DocGiaRepository repo;
    public List<DocGia> getAll(){
        return repo.findAll();
    }
}
