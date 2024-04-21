package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNV",nullable = false,unique = true)
    private int id;
    @Column(name = "TenNV",columnDefinition = "nvarchar2(40)")
    private String tenNV;
    private Date NgaySinh;
    @Column(name="Email",columnDefinition = "nvarchar2(50)",unique = true)
    private String email;
    @Column(name="SDT",columnDefinition = "nvarchar2(14)",unique = true)
    private String sdt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaChucVu",nullable = false)
    @JsonIgnore
    private ChucVu chucVu;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaTK",referencedColumnName = "MaTK")
    private TaiKhoan taiKhoan;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PhieuMuon> phieuMuons;

    public List<PhieuMuon> getPhieuMuons() {
        return phieuMuons;
    }

    public void setPhieuMuons(List<PhieuMuon> phieuMuons) {
        this.phieuMuons = phieuMuons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
