package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.ChucVu;
import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Service.ChucVuService;
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
public class TacGiaController {
    @Autowired
    private TacGiaService service;
    @GetMapping("/tacgia/index")
    public ResponseEntity<List<TacGia>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/tacgia/{id}")
    public ResponseEntity<TacGia> getOne(@PathVariable int id) {
        TacGia tg = service.getById(id);
        if(tg!=null) {
            return ResponseEntity.ok(tg);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/tacgia/{id}")
    public ResponseEntity<TacGia> update(@PathVariable int id, @RequestBody TacGia tg) {
        service.save(tg);
        return ResponseEntity.ok(tg);
    }
    @DeleteMapping("/tacgia/{id}")
    public ResponseEntity<TacGia> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}