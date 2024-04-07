package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.QuyenSach;
import Oracle.Backend.Model.TacGia;
import Oracle.Backend.Model.TinhTrangSach;
import Oracle.Backend.Service.QuyenSachService;
import Oracle.Backend.Service.TacGiaService;
import Oracle.Backend.Service.TinhTrangSachService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TinhTrangSachController {
    @Autowired
    private TinhTrangSachService service;
    @Autowired
    private QuyenSachService qsService;
    @GetMapping("/tinhtrangsach/index")
    public ResponseEntity<List<TinhTrangSach>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/tinhtrangsach/{id}")
    public ResponseEntity<TinhTrangSach> getOne(@PathVariable int id) {
        TinhTrangSach tts = service.getById(id);
        if(tts!=null) {
            return ResponseEntity.ok(tts);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/tinhtrangsach/{id}")
    public ResponseEntity<TinhTrangSach> update(@PathVariable int id, @RequestBody TinhTrangSach tts) {
        service.save(tts);
        return ResponseEntity.ok(tts);
    }
    @DeleteMapping("/tinhtrangsach/{id}")
    public ResponseEntity<TinhTrangSach> delete(@PathVariable int id) {
        //xoa ma tinh trang
        service.delete(id);
        //cap nhat ma tinh trang cua cac quyen sach ==null
        List<QuyenSach> update = qsService.getAllByMaTinhTrang(id);
        for(QuyenSach sach:update)
        {
            sach.setTinhTrangSach(null);
            qsService.save(sach);
        }
        //cap nhat ma tinh trang cua chi tiet phieu phat ==null
        return ResponseEntity.accepted().build();
    }

}