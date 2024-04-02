package Oracle.Backend.Model;

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

}
