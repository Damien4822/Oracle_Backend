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
    private int MaTheDocGia;
    private DATE NgayLap;
    private DATE NgayHetHan;
    private byte tinhtrang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaDocGia",nullable = false)
    @JsonIgnore
    private DocGia docgia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaPhieuDK",referencedColumnName = "MaPhieuDK")
    private PhieuDKTheDocGia phieuDK;
}
