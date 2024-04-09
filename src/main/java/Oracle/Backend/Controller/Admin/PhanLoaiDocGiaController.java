package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.DauSach;
import Oracle.Backend.Model.PhanLoaiDocGia;
import Oracle.Backend.Service.DauSachService;
import Oracle.Backend.Service.PhanLoaiDocGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PhanLoaiDocGiaController {
    @Autowired
    private PhanLoaiDocGiaService service;
    @GetMapping("/phanloaidocgia/index")
    public ResponseEntity<List<PhanLoaiDocGia>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/phanloaidocgia/{id}")
    public ResponseEntity<PhanLoaiDocGia> getOne(@PathVariable int id) {
        PhanLoaiDocGia pl = service.getById(id);
        if(pl!=null) {
            return ResponseEntity.ok(pl);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/phanloaidocgia/{id}")
    public ResponseEntity<PhanLoaiDocGia> update(@PathVariable int id, @RequestBody PhanLoaiDocGia pl) {
        service.save(pl);
        return ResponseEntity.ok(pl);
    }
    @DeleteMapping("/phanloaidocgia/{id}")
    public ResponseEntity<PhanLoaiDocGia> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}