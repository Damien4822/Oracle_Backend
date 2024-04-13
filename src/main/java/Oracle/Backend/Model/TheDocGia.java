package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="TheDocGia")
public class TheDocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTheDocGia;
    private DATE ngayLap;
    private DATE ngayHetHan;
    private byte tinhTrang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docGia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaPhieuDK",referencedColumnName = "MaPhieuDK")
    private PhieuDKTheDocGia phieuDK;

    public int getMaTheDocGia() {
        return maTheDocGia;
    }

    public void setMaTheDocGia(int maTheDocGia) {
        this.maTheDocGia = maTheDocGia;
    }

    public DATE getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(DATE ngayLap) {
        this.ngayLap = ngayLap;
    }

    public DATE getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(DATE ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public byte getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(byte tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public DocGia getDocGia() {
        return docGia;
    }

    public void setDocGia(DocGia docGia) {
        this.docGia = docGia;
    }

    public PhieuDKTheDocGia getPhieuDK() {
        return phieuDK;
    }

    public void setPhieuDK(PhieuDKTheDocGia phieuDK) {
        this.phieuDK = phieuDK;
    }
}
