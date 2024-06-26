package Oracle.Backend.Auth;

import Oracle.Backend.Config.JwtService;
import Oracle.Backend.Model.Role;
import Oracle.Backend.Model.TaiKhoan;
import Oracle.Backend.Repository.TaiKhoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private TaiKhoanRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        //User user=User.builder()
        //.username(request.getUsername())
        //.password(passwordEncoder.encode(request.getPassword()))
        //.role(Role.USER)
        //.build();
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap(request.getTenDangNhap());
        taiKhoan.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        //user.setPassword(request.getPassword());
        taiKhoan.setTinhTrang(1);
        taiKhoan.setPhanLoaiTaiKhoan(Role.DOCGIA);
        repo.save(taiKhoan);
        var jwtToken = jwtService.generateToken(taiKhoan);
        AuthenticationResponse response= new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;
    }

    public AuthenticationResponse authenticate( AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getTenDangNhap(), request.getMatKhau()
                )
        );

        TaiKhoan taiKhoan = repo.findTaiKhoanByTenDangNhap(request.getTenDangNhap())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(taiKhoan);
        AuthenticationResponse response= new AuthenticationResponse();
        response.setToken(jwtToken);
        System.out.println("this is token on authenticate");
        System.out.println(jwtToken);
        return response;
    }
}