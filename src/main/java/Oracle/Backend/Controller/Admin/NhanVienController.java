package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Model.NhanVien;
import Oracle.Backend.Service.DocGiaService;
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
public class NhanVienController {
    @Autowired
    private NhanVienService service;
    @GetMapping("/nhanvien/index")
    public ResponseEntity<List<NhanVien>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/nhanvien/{id}")
    public ResponseEntity<NhanVien> getOne(@PathVariable int id) {
        NhanVien nv = service.getById(id);
        if(nv!=null) {
            return ResponseEntity.ok(nv);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/nhanvien/{id}")
    public ResponseEntity<NhanVien> update(@PathVariable int id, @RequestBody NhanVien nv) {
        service.save(nv);
        return ResponseEntity.ok(nv);
    }
    @DeleteMapping("/nhanvien/{id}")
    public ResponseEntity<NhanVien> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}