package Oracle.Backend.Controller.DocGia;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/docgia")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CheckController {
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
