package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Service.TacGiaService;
import Oracle.Backend.Service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService service;
    @GetMapping("/taikhoan/index")
    public ResponseEntity<List<TaiKhoan>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/taikhoan/{id}")
    public ResponseEntity<TaiKhoan> getOne(@PathVariable int id) {
        TaiKhoan tk = service.getById(id);
        if(tk!=null) {
            return ResponseEntity.ok(tk);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/taikhoan/{id}")
    public ResponseEntity<TaiKhoan> update(@PathVariable int id, @RequestBody TaiKhoan tk) {
        service.save(tk);
        return ResponseEntity.ok(tk);
    }
    @DeleteMapping("/taikhoan/{id}")
    public ResponseEntity<TaiKhoan> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
