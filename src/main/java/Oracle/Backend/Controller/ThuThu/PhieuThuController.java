package Oracle.Backend.Controller.ThuThu;

import Oracle.Backend.Model.ChiTietPhieuPhat;
import Oracle.Backend.Model.ChiTietPhieuThu;
import Oracle.Backend.Model.PhieuPhat;
import Oracle.Backend.Model.PhieuThu;
import Oracle.Backend.Service.ChiTietPhieuPhatService;
import Oracle.Backend.Service.ChiTietPhieuThuService;
import Oracle.Backend.Service.PhieuPhatService;
import Oracle.Backend.Service.PhieuThuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/thuthu")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PhieuThuController {
    @Autowired
    private PhieuThuService service;
    @Autowired
    private ChiTietPhieuThuService CTservice;
    @GetMapping("/phieuthu/index")
    public ResponseEntity<List<PhieuThu>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/phieuthu/{id}")
    public ResponseEntity< PhieuThu> getOne(@PathVariable int id) {
        PhieuThu pt = service.getById(id);
        if(pt!=null) {
            return ResponseEntity.ok(pt);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("/phieuthu/create")
    public ResponseEntity< PhieuThu> create(@RequestBody  PhieuThu phieu) {
        service.save(phieu);
        return ResponseEntity.ok(phieu);
    }
    @PutMapping("/phieuthu/{id}")
    public ResponseEntity< PhieuThu> update(@PathVariable int id, @RequestBody  PhieuThu pt) {
        service.save(pt);
        return ResponseEntity.ok(pt);
    }
    @DeleteMapping("/phieuthu/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/phieuthu/{id}/ctphieuthu/index")
    public ResponseEntity<List<ChiTietPhieuThu>> getAll(@PathVariable int id)
    {
        List<ChiTietPhieuThu> chiTietPhieuThuList = CTservice.getAllByMaPhieuThu(id);
        return ResponseEntity.ok(chiTietPhieuThuList);
    }
}