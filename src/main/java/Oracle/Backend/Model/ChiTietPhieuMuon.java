package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChiTietPhieuMuon")
public class ChiTietPhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChiTietPhieuMuon")
    private int id;
    @Column(columnDefinition = "integer")
    private int thanhTien;
    @Column(columnDefinition = "number(2,0)")
    private int soLuong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaPhieuMuon",nullable = false)
    @JsonIgnore
    private PhieuMuon phieuMuon;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaQuyenSach", referencedColumnName = "MaQuyenSach")
    private QuyenSach quyenSach;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public PhieuMuon getPhieuMuon() {
        return phieuMuon;
    }

    public void setPhieuMuon(PhieuMuon phieuMuon) {
        this.phieuMuon = phieuMuon;
    }

    public QuyenSach getQuyenSach() {
        return quyenSach;
    }

    public void setQuyenSach(QuyenSach quyenSach) {
        this.quyenSach = quyenSach;
    }
}
