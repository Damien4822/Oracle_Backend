package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChiTietPhieuThu")
public class ChiTietPhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChiTietPhieuThu")
    private int id;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaPhieuDKTheDocGia", referencedColumnName = "MaPhieuDK")
    private PhieuDKTheDocGia phieuDKTheDocGia;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaPhieuMuon", referencedColumnName = "MaPhieuMuon")
    private PhieuMuon phieuMuon;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaPhieuPhat", referencedColumnName = "MaPhieuPhat")
    private PhieuPhat phieuPhat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaPhieuThu",nullable = false)
    @JsonIgnore
    private PhieuThu phieuThu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public PhieuDKTheDocGia getPhieuDKTheDocGia() {
        return phieuDKTheDocGia;
    }

    public void setPhieuDKTheDocGia(@Nullable PhieuDKTheDocGia phieuDKTheDocGia) {
        this.phieuDKTheDocGia = phieuDKTheDocGia;
    }

    @Nullable
    public PhieuMuon getPhieuMuon() {
        return phieuMuon;
    }

    public void setPhieuMuon(@Nullable PhieuMuon phieuMuon) {
        this.phieuMuon = phieuMuon;
    }

    @Nullable
    public PhieuPhat getPhieuPhat() {
        return phieuPhat;
    }

    public void setPhieuPhat(@Nullable PhieuPhat phieuPhat) {
        this.phieuPhat = phieuPhat;
    }

    public PhieuThu getPhieuThu() {
        return phieuThu;
    }

    public void setPhieuThu(PhieuThu phieuThu) {
        this.phieuThu = phieuThu;
    }
}
