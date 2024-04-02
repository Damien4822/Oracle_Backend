package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PhieuPhat")
public class PhieuPhat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuPhat")
    private int id;
    private Date NgayLap;
    @Column(columnDefinition = "integer")
    private int SoTienPhat;
    @Column(columnDefinition = "nvarchar2(40)")
    private String NoiDung;

}
