package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="TheDocGia")
public class TheDocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTheDocGia;
    private DATE ngayLap;
    private DATE ngayHetHan;
    private byte tinhTrang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docGia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaPhieuDK",referencedColumnName = "MaPhieuDK")
    private PhieuDKTheDocGia phieuDK;
}
