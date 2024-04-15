package Oracle.Backend.Controller.DocGia;

import Oracle.Backend.Model.DauSach;
import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Service.DauSachService;
import Oracle.Backend.Service.DocGiaService;
import Oracle.Backend.Service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/docgia")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DocGia_DocGiaController {
    @Autowired
    private DocGiaService service;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private DauSachService dauSachService;
    @GetMapping("/getInfo/{ten}")
    private ResponseEntity<DocGia> getInfo(@PathVariable String ten)
    {
        Optional<TaiKhoan> tk= taiKhoanService.getByTenDangNhap(ten);
        if(tk !=null)
        {
            DocGia dg= service.getByTaiKhoan(tk);
            return ResponseEntity.ok(dg);
        }
        else return ResponseEntity.notFound().build();
    }
   @PutMapping("/update")
    private ResponseEntity<DocGia> update(@RequestBody DocGia docGia)
    {
        DocGia docgia= service.getById(docGia.getId());
        docgia.setSDT(docGia.getSDT());
        docgia.setEmail(docGia.getEmail());
        docgia.setTenDocGia(docGia.getTenDocGia());
        docgia.setNgaySinh(docGia.getNgaySinh());
        service.save(docgia);
        return ResponseEntity.ok().build();
    }

}
