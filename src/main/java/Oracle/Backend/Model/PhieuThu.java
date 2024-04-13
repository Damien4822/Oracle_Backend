package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.math.BigInteger;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PhieuThu")
public class PhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuThu")
    private int id;
    private DATE ngayLap;
    @Column(columnDefinition = "integer")
    private BigInteger soTien;
    private String noiDung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docGia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaNV",nullable = false)
    @JsonIgnore
    private NhanVien nhanVien;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaChiTietPhieuThu", referencedColumnName = "MaChiTietPhieuThu")
    private ChiTietPhieuThu chiTietPhieuThu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DATE getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(DATE ngayLap) {
        this.ngayLap = ngayLap;
    }

    public BigInteger getSoTien() {
        return soTien;
    }

    public void setSoTien(BigInteger soTien) {
        this.soTien = soTien;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public DocGia getDocGia() {
        return docGia;
    }

    public void setDocGia(DocGia docGia) {
        this.docGia = docGia;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Nullable
    public ChiTietPhieuThu getChiTietPhieuThu() {
        return chiTietPhieuThu;
    }

    public void setChiTietPhieuThu(@Nullable ChiTietPhieuThu chiTietPhieuThu) {
        this.chiTietPhieuThu = chiTietPhieuThu;
    }
}
