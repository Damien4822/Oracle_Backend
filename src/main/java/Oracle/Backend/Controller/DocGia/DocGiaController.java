package Oracle.Backend.Controller.DocGia;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Service.DocGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/docgia")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DocGiaController {
    @Autowired
    private DocGiaService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<DocGia>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/docgia/{id}")
    public ResponseEntity<DocGia> getOne(@PathVariable int id) {
        DocGia docGia = service.getById(id);
        if(docGia!=null) {
            return ResponseEntity.ok(docGia);
        }
        else
            return ResponseEntity.notFound().build();
    }
}
