package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="DocGia")
public class DocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDocGia",  nullable = false)
    private int id;
    @Column(name = "TenDocGia", columnDefinition = "nvarchar2(40)", nullable = false,length = 40)
    private String tenDocGia;
    @Column(name = "NgaySinh", columnDefinition = "Date", nullable = false)
    private Date ngaySinh;
    @Column(name = "Email", columnDefinition = "nvarchar2(40)", nullable = false,length = 40)
    private String email;

    @Lob
    @Nullable
    private Blob avatar;
    @Column(name = "SDT", columnDefinition = "nvarchar2(11)", nullable = false,length = 11)
    private String SDT;
    @Lob
    @Nullable
    private Blob hinhAnhMinhChung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaPLDG",nullable = false)
    @JsonIgnore
    private PhanLoaiDocGia phanloai;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaTaiKhoan",referencedColumnName = "MaTK")
    private TaiKhoan taiKhoan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }



    public PhanLoaiDocGia getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(PhanLoaiDocGia phanloai) {
        this.phanloai = phanloai;
    }

    @Nullable
    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(@Nullable TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Nullable
    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(@Nullable Blob avatar) {
        this.avatar = avatar;
    }

    public String getSdt() {
        return SDT;
    }

    public void setSdt(String sdt) {
        this.SDT = sdt;
    }

    @Nullable
    public Blob getHinhAnhMinhChung() {
        return hinhAnhMinhChung;
    }

    public void setHinhAnhMinhChung(@Nullable Blob hinhAnhMinhChung) {
        this.hinhAnhMinhChung = hinhAnhMinhChung;
    }
}
