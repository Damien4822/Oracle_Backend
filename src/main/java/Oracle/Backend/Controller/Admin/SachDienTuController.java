package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.SachDienTu;
import Oracle.Backend.Service.SachDienTuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class SachDienTuController {
    @Autowired
    private SachDienTuService service;
    @GetMapping("/sachdientu/index")
    public ResponseEntity<List<SachDienTu>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/sachdientu/{id}")
    public ResponseEntity<SachDienTu> getOne(@PathVariable int id) {
        SachDienTu sdt = service.getById(id);
        if(sdt!=null) {
            return ResponseEntity.ok(sdt);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/sachdientu/{id}")
    public ResponseEntity<SachDienTu> update(@PathVariable int id, @RequestBody SachDienTu sdt) {
        service.save(sdt);
        return ResponseEntity.ok(sdt);
    }
    @DeleteMapping("/sachdientu/{id}")
    public ResponseEntity<SachDienTu> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}