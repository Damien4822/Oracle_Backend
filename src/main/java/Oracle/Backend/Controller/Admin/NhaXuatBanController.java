package Oracle.Backend.Controller.Admin;

import Oracle.Backend.Model.ChucVu;
import Oracle.Backend.Model.NhaXuatBan;
import Oracle.Backend.Service.ChucVuService;
import Oracle.Backend.Service.NhaXuatBanService;
import Oracle.Backend.Service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class NhaXuatBanController {
    @Autowired
    private NhaXuatBanService service;
    @GetMapping("/nxb/index")
    public ResponseEntity<List<NhaXuatBan>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/nxb/{id}")
    public ResponseEntity<NhaXuatBan> getOne(@PathVariable int id) {
        NhaXuatBan nxb = service.getById(id);
        if(nxb!=null) {
            return ResponseEntity.ok(nxb);
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/nxb/{id}")
    public ResponseEntity<NhaXuatBan> update(@PathVariable int id, @RequestBody NhaXuatBan nxb) {
        service.save(nxb);
        return ResponseEntity.ok(nxb);
    }
    @DeleteMapping("/nxb/{id}")
    public ResponseEntity<NhaXuatBan> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}