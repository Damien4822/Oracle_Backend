package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.math.BigInteger;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PhieuThu")
public class PhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuThu")
    private int id;
    private DATE NgayLap;
    @Column(columnDefinition = "integer")
    private BigInteger SoTien;
    private String NoiDung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docGia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaNV",nullable = false)
    @JsonIgnore
    private NhanVien nhanVien;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaChiTietPhieuThu", referencedColumnName = "MaChiTietPhieuThu")
    private ChiTietPhieuThu chiTietPhieuThu;
}
