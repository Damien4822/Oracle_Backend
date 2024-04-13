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
@Table(name = "ChiTietPhieuPhat")
public class ChiTietPhieuPhat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCTPP")
    private int id;
    private int thanhTien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaTinhTrang",nullable = false)
    @JsonIgnore
    private TinhTrangSach tinhTrangSach;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaPhieuPhat",nullable = false)
    @JsonIgnore
    private PhieuPhat phieuPhat;
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

    public TinhTrangSach getTinhTrangSach() {
        return tinhTrangSach;
    }

    public void setTinhTrangSach(TinhTrangSach tinhTrangSach) {
        this.tinhTrangSach = tinhTrangSach;
    }

    public PhieuPhat getPhieuPhat() {
        return phieuPhat;
    }

    public void setPhieuPhat(PhieuPhat phieuPhat) {
        this.phieuPhat = phieuPhat;
    }

    public QuyenSach getQuyenSach() {
        return quyenSach;
    }

    public void setQuyenSach(QuyenSach quyenSach) {
        this.quyenSach = quyenSach;
    }
}
