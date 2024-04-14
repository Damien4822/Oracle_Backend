package Oracle.Backend.Controller.DocGia;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Service.DocGiaService;
import Oracle.Backend.Service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getInfo")
    private ResponseEntity<DocGia> getInfo(@RequestBody String ten)
    {
        Optional<TaiKhoan> tk= taiKhoanService.getByTenDangNhap(ten);
        if(tk !=null)
        {
            DocGia dg= service.getByTaiKhoan(tk);
            return ResponseEntity.ok(dg);
        }
        else return ResponseEntity.notFound().build();
    }
}
