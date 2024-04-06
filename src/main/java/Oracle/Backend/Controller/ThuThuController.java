package Oracle.Backend.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/thuthu")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ThuThuController {
}
