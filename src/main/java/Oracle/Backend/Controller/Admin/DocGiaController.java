package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Model.NhanVien;
import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Service.DocGiaService;
import Oracle.Backend.Service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DocGiaController {
    @Autowired
    private DocGiaService docGiaService;
    @Autowired
    TaiKhoanService taiKhoanService;
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
    @PostMapping("/docgia/create")
    public ResponseEntity<DocGia> create(@RequestBody DocGia dg) {
        docGiaService.save(dg);
        return ResponseEntity.ok(dg);
    }
    @PutMapping("/docgia/{id}")
    public ResponseEntity<DocGia> update(@PathVariable int id, @RequestBody DocGia docGia) {
        docGiaService.save(docGia);
        return ResponseEntity.ok(docGia);
    }
    @DeleteMapping("/docgia/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        docGiaService.delete(id);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/docgia/taikhoan/{matk}")
    public ResponseEntity<DocGia> getOneByTaiKhoan(@PathVariable int matk) {
        TaiKhoan tk= taiKhoanService.getById(matk);
        if(tk!=null) {
            DocGia dg = docGiaService.getByTaiKhoan(Optional.of(tk));
            return ResponseEntity.ok().body(dg);
        }
        else
            return ResponseEntity.notFound().build();
    }
}
