package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PhieuDKTheDocGia")
public class PhieuDKTheDocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maPhieuDK;
    private DATE ngayLap;
    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaNV",nullable = false)
    @JsonIgnore
    private NhanVien nhanVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docGia;

    public int getMaPhieuDK() {
        return maPhieuDK;
    }

    public void setMaPhieuDK(int maPhieuDK) {
        this.maPhieuDK = maPhieuDK;
    }

    public DATE getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(DATE ngayLap) {
        this.ngayLap = ngayLap;
    }

    @Nullable
    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(@Nullable NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public DocGia getDocGia() {
        return docGia;
    }

    public void setDocGia(DocGia docGia) {
        this.docGia = docGia;
    }
}
