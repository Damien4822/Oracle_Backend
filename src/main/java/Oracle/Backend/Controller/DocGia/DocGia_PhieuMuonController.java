package Oracle.Backend.Controller.DocGia;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import Oracle.Backend.Model.PhieuMuon;
import Oracle.Backend.Service.ChiTietPhieuMuonService;
import Oracle.Backend.Service.PhieuMuonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/docgia")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DocGia_PhieuMuonController {
    @Autowired
    private PhieuMuonService service;
    @Autowired
    private ChiTietPhieuMuonService CTservice;
    @GetMapping("/phieumuon/index")
    public ResponseEntity<List<PhieuMuon>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/phieumuon/{id}")
    public ResponseEntity<PhieuMuon> getOne(@PathVariable int id) {
        PhieuMuon pm = service.getById(id);
        if(pm!=null) {
            return ResponseEntity.ok(pm);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("/phieumuon/create")
    public ResponseEntity<PhieuMuon> create(@RequestBody PhieuMuon phieu) {
        phieu.setNhanVien(null);
        service.save(phieu);
        return ResponseEntity.ok(phieu);
    }
    @PutMapping("/phieumuon/{id}")
    public ResponseEntity<PhieuMuon> update(@PathVariable int id, @RequestBody PhieuMuon pm) {
        service.save(pm);
        return ResponseEntity.ok(pm);
    }

    @DeleteMapping("/phieumuon/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/phieumuon/{id}/ctphieumuon/index")
    public ResponseEntity<List<ChiTietPhieuMuon>> getAll(@PathVariable int id)
    {
        List<ChiTietPhieuMuon> chiTietPhieuMuonList = CTservice.getAllByMaPhieuMuon(id);
        return ResponseEntity.ok(chiTietPhieuMuonList);
    }
    @PostMapping("/phieumuon/{id}/ctphieumuon/create")
    public ResponseEntity<List<ChiTietPhieuMuon>> getAll(@PathVariable int id,List<ChiTietPhieuMuon> list)
    {
        for(ChiTietPhieuMuon ct : list)
        {
            CTservice.save(ct);
        }
        List<ChiTietPhieuMuon> chiTietPhieuMuonList = CTservice.getAllByMaPhieuMuon(id);
        return ResponseEntity.ok(chiTietPhieuMuonList);
    }
}