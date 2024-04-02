package Oracle.Backend.Model;

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
    private int ThanhTien;
    @Column(columnDefinition = "number(2,0)")
    private int SoLuong;
}
