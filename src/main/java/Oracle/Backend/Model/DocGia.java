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
    private int maDocGia;
    @Column(name = "TenDocGia", columnDefinition = "nvarchar2(40)", nullable = false,length = 40)
    private String tenDocGia;
    @Column(name = "NgaySinh", columnDefinition = "Date", nullable = false)
    private Date NgaySinh;
    @Column(name = "Email", columnDefinition = "nvarchar2(40)", nullable = false,length = 40)
    private String email;

    @Lob
    @Nullable
    private Blob Avatar;
    @Column(name = "SDT", columnDefinition = "nvarchar2(11)", nullable = false,length = 11)
    private String SDT;
    @Lob
    @Nullable
    private Blob HinhAnhMinhChung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaPLDG",nullable = false)
    @JsonIgnore
    private PhanLoaiDocGia phanloai;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaTaiKhoan",referencedColumnName = "MaTK")
    private TaiKhoan taiKhoan;

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }



    public Blob getAvatar() {
        return Avatar;
    }

    public void setAvatar(Blob avatar) {
        Avatar = avatar;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Nullable
    public Blob getHinhAnhMinhChung() {
        return HinhAnhMinhChung;
    }

    public void setHinhAnhMinhChung(@Nullable Blob hinhAnhMinhChung) {
        HinhAnhMinhChung = hinhAnhMinhChung;
    }


}
