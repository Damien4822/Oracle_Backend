package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PhieuMuon")
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="MaPhieuMuon" )
    private int id;
    private Date NgayLap;
    private Date NgayMuon;
    private Date NgayTra;
    @Column(columnDefinition = "integer")
    private int TongTien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docGia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaNV",nullable = false)
    @JsonIgnore
    private NhanVien nhanVien;
}
