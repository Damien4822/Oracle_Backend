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
    private Date ngayLap;
    private Date ngayHetHan;
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

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
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
