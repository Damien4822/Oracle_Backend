package Oracle.Backend.Controller.ThuThu;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import Oracle.Backend.Model.ChiTietPhieuPhat;
import Oracle.Backend.Model.PhieuMuon;
import Oracle.Backend.Model.PhieuPhat;
import Oracle.Backend.Service.ChiTietPhieuMuonService;
import Oracle.Backend.Service.ChiTietPhieuPhatService;
import Oracle.Backend.Service.PhieuMuonService;
import Oracle.Backend.Service.PhieuPhatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/thuthu")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PhieuPhatController {
    @Autowired
    private PhieuPhatService service;
    @Autowired
    private ChiTietPhieuPhatService CTservice;
    @GetMapping("/phieuphat/index")
    public ResponseEntity<List<PhieuPhat>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/phieuphat/{id}")
    public ResponseEntity< PhieuPhat> getOne(@PathVariable int id) {
        PhieuPhat pp = service.getById(id);
        if(pp!=null) {
            return ResponseEntity.ok(pp);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("/phieuphat/create")
    public ResponseEntity<PhieuPhat> create(@RequestBody PhieuPhat phieu) {
        service.save(phieu);
        return ResponseEntity.ok(phieu);
    }
    @PutMapping("/phieuphat/{id}")
    public ResponseEntity< PhieuPhat> update(@PathVariable int id, @RequestBody  PhieuPhat pp) {
        service.save(pp);
        return ResponseEntity.ok(pp);
    }
    @DeleteMapping("/phieuphat/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

   @GetMapping("/phieuphat/{id}/ctphieuphat/index")
    public ResponseEntity<List<ChiTietPhieuPhat>> getAll(@PathVariable int id)
    {
     List<ChiTietPhieuPhat> chiTietPhieuPhats = CTservice.getAllByMaPhieuPhat(id);
        return ResponseEntity.ok(chiTietPhieuPhats);
   }
}