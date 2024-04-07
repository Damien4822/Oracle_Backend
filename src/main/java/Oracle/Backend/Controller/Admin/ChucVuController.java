package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.ChucVu;
import Oracle.Backend.Model.NhanVien;
import Oracle.Backend.Service.ChucVuService;
import Oracle.Backend.Service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ChucVuController {
    @Autowired
    private ChucVuService service;
    @GetMapping("/chucvu/index")
    public ResponseEntity<List<ChucVu>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/chucvu/{id}")
    public ResponseEntity<ChucVu> getOne(@PathVariable int id) {
        ChucVu cv = service.getById(id);
        if(cv!=null) {
            return ResponseEntity.ok(cv);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/chucvu/{id}")
    public ResponseEntity<ChucVu> update(@PathVariable int id, @RequestBody ChucVu cv) {
        service.save(cv);
        return ResponseEntity.ok(cv);
    }
    @DeleteMapping("/chucvu/{id}")
    public ResponseEntity<ChucVu> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}