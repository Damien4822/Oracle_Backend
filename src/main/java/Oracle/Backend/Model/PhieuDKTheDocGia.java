package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PhieuDKTheDocGia")
public class PhieuDKTheDocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaPhieuDK;
    private DATE NgayLap;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaNV",nullable = false)
    @JsonIgnore
    private NhanVien nhanVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docGia;
}
