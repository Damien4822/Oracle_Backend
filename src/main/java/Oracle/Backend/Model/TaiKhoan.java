package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="TaiKhoan")
public class TaiKhoan implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTK",unique = true)
    private int maTK;
    @Column(name="TenDangNhap",columnDefinition = "nvarchar2(40)",unique = true,nullable = false)
    private String tenDangNhap;
    @Column(name = "MatKhau",columnDefinition = "nvarchar2(120)",nullable = false)
    private String matKhau;
    @Column(name="TinhTrang",columnDefinition = "number(1,0)",nullable = false)
    private int tinhTrang;
    @Enumerated(EnumType.STRING)
    @Column(name = "PhanLoaiTaiKhoan",columnDefinition = "nvarchar2(50)")
    private Role phanLoaiTaiKhoan;

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Role getPhanLoaiTaiKhoan() {
        return phanLoaiTaiKhoan;
    }

    public void setPhanLoaiTaiKhoan(Role phanLoaiTaiKhoan) {
        this.phanLoaiTaiKhoan = phanLoaiTaiKhoan;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(String.valueOf(phanLoaiTaiKhoan.toString())));
    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public String getUsername() {
        return tenDangNhap;
    }

    @Override
    public boolean isAccountNonExpired() {
        return  true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
