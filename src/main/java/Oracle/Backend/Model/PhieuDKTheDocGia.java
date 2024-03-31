package Oracle.Backend.Model;

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
}
