package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.DauSach;
import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Service.DauSachService;
import Oracle.Backend.Service.TacGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DauSachController {
    @Autowired
    private DauSachService service;
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
    @PutMapping("/dausach/{id}")
    public ResponseEntity<DauSach> update(@PathVariable int id, @RequestBody DauSach ds) {
        service.save(ds);
        return ResponseEntity.ok(ds);
    }
    @DeleteMapping("/dausach/{id}")
    public ResponseEntity<DauSach> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}