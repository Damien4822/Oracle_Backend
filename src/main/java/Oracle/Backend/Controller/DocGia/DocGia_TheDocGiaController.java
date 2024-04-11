package Oracle.Backend.Controller.DocGia;

import Oracle.Backend.Model.TheDocGia;
import Oracle.Backend.Service.TheDocGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/docgia")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DocGia_TheDocGiaController {
    @Autowired
    private TheDocGiaService service;

    @GetMapping("/{id}/thedocgia/index")
    public ResponseEntity<List<TheDocGia>> getAll(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getAllByMaDocGia(id));
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
}