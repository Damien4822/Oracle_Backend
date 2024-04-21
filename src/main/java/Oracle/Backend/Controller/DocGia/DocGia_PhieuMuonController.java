package Oracle.Backend.Controller.DocGia;

import Oracle.Backend.Model.ChiTietPhieuMuon;
import Oracle.Backend.Model.PhieuMuon;
import Oracle.Backend.Model.QuyenSach;
import Oracle.Backend.Service.ChiTietPhieuMuonService;
import Oracle.Backend.Service.DocGiaService;
import Oracle.Backend.Service.PhieuMuonService;
import Oracle.Backend.Service.QuyenSachService;
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
    @Autowired
    private QuyenSachService quyenSachService;
    @Autowired
    private DocGiaService docGiaService;
    @GetMapping("/{id}/phieumuon/index")
    public ResponseEntity<List<PhieuMuon>> getAllByDocGiaId(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getAllByDocGiaId(id));
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
    @PostMapping("/{id}/phieumuon/create")
    @ResponseBody
    public ResponseEntity<PhieuMuon> create(@PathVariable int id,@RequestBody PhieuMuon phieu) {
        PhieuMuon create = new PhieuMuon();
        create.setDocGia(docGiaService.getById(id));
        create.setTinhTrangPhieu(false);
        create.setNhanVien(phieu.getNhanVien());
        create.setNgayMuon(phieu.getNgayMuon());
        create.setNgayLap(phieu.getNgayLap());
        create.setNgayTra(phieu.getNgayTra());
        create.setTongTien(phieu.getTongTien());
        service.save(create);
        return ResponseEntity.ok(create);
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
    public ResponseEntity<List<ChiTietPhieuMuon>> getAll(@PathVariable int id,@RequestBody List<ChiTietPhieuMuon> list)
    {   PhieuMuon phieu = service.getById(id);
        for(ChiTietPhieuMuon ct : list)
        {
            ct.setPhieuMuon(phieu);
            CTservice.save(ct);
        }
        List<ChiTietPhieuMuon> chiTietPhieuMuonList = CTservice.getAllByMaPhieuMuon(id);
        return ResponseEntity.ok(chiTietPhieuMuonList);
    }
    @GetMapping("/quyensach/index")
    public ResponseEntity<List<QuyenSach>> getAll()
    {
        List<QuyenSach> list = quyenSachService.getAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/quyensach/{id}")
    public ResponseEntity<QuyenSach> getOneById(@PathVariable int id)
    {
        QuyenSach get = quyenSachService.getById(id);
        return ResponseEntity.ok(get);
    }
}