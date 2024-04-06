package Oracle.Backend.Controller;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Repository.DocGiaRepository;
import Oracle.Backend.Service.DocGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminController {
    @Autowired
    private DocGiaService docGiaService;
    @GetMapping("/docgia/index")
    public ResponseEntity<List<DocGia>> getAll()
    {
        return ResponseEntity.ok(docGiaService.getAll());
    }
    @GetMapping("/docgia/{id}")
    public ResponseEntity<DocGia> getOne(@PathVariable int id) {
        DocGia docGia = docGiaService.getById(id);
        if(docGia!=null) {
            return ResponseEntity.ok(docGia);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/docgia/{id}")
    public ResponseEntity<DocGia> update(@PathVariable int id, @RequestBody DocGia docGia) {
        docGiaService.save(docGia);
        return ResponseEntity.ok(docGia);
    }
    @DeleteMapping("/docgia/{id}")
    public ResponseEntity<DocGia> delete(@PathVariable int id) {
        docGiaService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
