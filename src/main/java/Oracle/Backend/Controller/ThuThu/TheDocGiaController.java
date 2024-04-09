package Oracle.Backend.Controller.ThuThu;

import Oracle.Backend.Model.ChiTietPhieuThu;
import Oracle.Backend.Model.PhieuPhat;
import Oracle.Backend.Model.PhieuThu;
import Oracle.Backend.Model.TheDocGia;
import Oracle.Backend.Service.ChiTietPhieuThuService;
import Oracle.Backend.Service.PhieuThuService;
import Oracle.Backend.Service.TheDocGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/thuthu")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TheDocGiaController {
    @Autowired
    private TheDocGiaService service;

    @GetMapping("/thedocgia/index")
    public ResponseEntity<List<TheDocGia>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/thedocgia/{id}")
    public ResponseEntity<TheDocGia> getOne(@PathVariable int id) {
        TheDocGia tdg = service.getById(id);
        if(tdg!=null) {
            return ResponseEntity.ok(tdg);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("/thedocgia/create")
    public ResponseEntity<TheDocGia> create(@RequestBody TheDocGia phieu) {
        service.save(phieu);
        return ResponseEntity.ok(phieu);
    }
    @PutMapping("/thedocgia/{id}")
    public ResponseEntity<TheDocGia> update(@PathVariable int id, @RequestBody TheDocGia tdg) {
        service.save(tdg);
        return ResponseEntity.ok(tdg);
    }
    @DeleteMapping("/thedocgia/{id}")
    public ResponseEntity<TheDocGia> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }


}