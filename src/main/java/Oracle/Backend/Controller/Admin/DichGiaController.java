package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.DichGia;
import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Service.DichGiaService;
import Oracle.Backend.Service.TacGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class DichGiaController {
    @Autowired
    private DichGiaService service;
    @GetMapping("/dichgia/index")
    public ResponseEntity<List<DichGia>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/dichgia/{id}")
    public ResponseEntity<DichGia> getOne(@PathVariable int id) {
        DichGia dg = service.getById(id);
        if(dg!=null) {
            return ResponseEntity.ok(dg);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/dichgia/{id}")
    public ResponseEntity<DichGia> update(@PathVariable int id, @RequestBody DichGia dg) {
        service.save(dg);
        return ResponseEntity.ok(dg);
    }
    @DeleteMapping("/dichgia/{id}")
    public ResponseEntity<DichGia> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}