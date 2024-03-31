package Oracle.Backend.Model;

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

}
