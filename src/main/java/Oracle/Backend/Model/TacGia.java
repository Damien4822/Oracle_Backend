package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TacGia")
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTacGia")
    private int id;
    @Column(columnDefinition = "nvarchar2(40)")
   private String TenTacGia;
    @Column(columnDefinition = "number(4,0)")
    private int NamSinh;
    @Column(columnDefinition = "number(4,0)")
    private int NamMat;

}
