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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaPLTK",nullable = false)
    @JsonIgnore
    private PhanLoaiTaiKhoan phanloai;

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

    public PhanLoaiTaiKhoan getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(PhanLoaiTaiKhoan phanloai) {
        this.phanloai = phanloai;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(String.valueOf(phanloai.getId())));
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
