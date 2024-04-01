package Oracle.Backend.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DichGia")
public class DichGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDichGia")
    private int id;
    @Column(columnDefinition = "nvarchar2(40)")
    private String TenDichGia;
    @Nullable
    @Column(columnDefinition = "number(4,0)")
    private int NamSinh;
    @Nullable
    @Column(columnDefinition = "number(4,0)")
    private Date NamMat;
}
