package Oracle.Backend.Controller.PublicController;

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
@RequestMapping("/public")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Public_TacGiaController {
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

}