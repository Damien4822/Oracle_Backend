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
    private int ThanhTien;
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
}
