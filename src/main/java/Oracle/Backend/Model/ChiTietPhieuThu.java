package Oracle.Backend.Model;

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
    @JoinColumn(name = "PhieuDKTheDocGia_id", referencedColumnName = "MaPhieuDK")
    private PhieuDKTheDocGia phieuDKTheDocGia;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PhieuMuon_id", referencedColumnName = "MaPhieuMuon")
    private PhieuMuon phieuMuon;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PhieuPhat_id", referencedColumnName = "MaPhieuPhat")
    private PhieuPhat phieuPhat;
}
