package Oracle.Backend.Controller.DocGia;

import Oracle.Backend.Model.PhieuDKTheDocGia;
import Oracle.Backend.Service.PhieuDKTheDocGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/docgia")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PhieuDKTheDocGiaController {
    @Autowired
    private PhieuDKTheDocGiaService service;
    @GetMapping("/phieudkthedocgia/index")
    public ResponseEntity<List<PhieuDKTheDocGia>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/phieudkthedocgia/{id}")
    public ResponseEntity<PhieuDKTheDocGia> getOne(@PathVariable int id) {
        PhieuDKTheDocGia phieu = service.getById(id);
        if(phieu!=null) {
            return ResponseEntity.ok(phieu);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("/phieudkthedocgia/create")
    public ResponseEntity<PhieuDKTheDocGia> create(@RequestBody PhieuDKTheDocGia phieu) {
        service.save(phieu);
        return ResponseEntity.ok(phieu);
    }
    @PutMapping("/phieudkthedocgia/{id}")
    public ResponseEntity<PhieuDKTheDocGia> update(@PathVariable int id, @RequestBody PhieuDKTheDocGia phieu) {
        service.save(phieu);
        return ResponseEntity.ok(phieu);
    }
    @DeleteMapping("/phieudkthedocgia/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}