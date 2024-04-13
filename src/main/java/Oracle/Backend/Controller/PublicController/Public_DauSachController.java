package Oracle.Backend.Controller.PublicController;

import Oracle.Backend.Model.DauSach;
import Oracle.Backend.Model.QuyenSach;
import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Service.DauSachService;
import Oracle.Backend.Service.QuyenSachService;
import Oracle.Backend.Service.TacGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/public")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Public_DauSachController {
    @Autowired
    private DauSachService service;
    @Autowired
    private TacGiaService tacGiaService;
    @Autowired
    private QuyenSachService QSservice;
    @GetMapping("/dausach/index")
    public ResponseEntity<List<DauSach>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/dausach/{id}")
    public ResponseEntity<DauSach> getOne(@PathVariable int id) {
        DauSach ds = service.getById(id);
        if(ds!=null) {
            return ResponseEntity.ok(ds);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/dausach/{id}/quyensach/index")
    public ResponseEntity<List<QuyenSach>> getAll(@PathVariable int id)
    {
        List<QuyenSach> list = QSservice.getAllByMaDauSach(id);
        if(list!=null)
        return ResponseEntity.ok(list);
        else return ResponseEntity.noContent().build();
    }
    @GetMapping("/dausach/{id}/tacgia/index")
    public ResponseEntity<List<TacGia>> getAllTG(@PathVariable int id)
    {
        DauSach ds = service.getById(id);
        List<TacGia> tg = ds.getTacGiaList();
        return ResponseEntity.ok(tg);
    }
}