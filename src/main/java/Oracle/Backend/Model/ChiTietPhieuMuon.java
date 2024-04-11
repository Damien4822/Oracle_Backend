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

    public ChiTietPhieuMuon(ChiTietPhieuMuon ct) {
        this.id = ct.id;
        thanhTien = ct.thanhTien;
        soLuong = ct.soLuong;
        this.phieuMuon = ct.phieuMuon;
        this.quyenSach = ct.quyenSach;
    }
}
