package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChucVu")
    private int id;
    @Column(name = "TenChucVu",columnDefinition = "nvarchar2(30)",nullable = false)
    private String TenChucVu;
    @Column(name = "MoTa",columnDefinition = "nvarchar2(40)",nullable = false)
    private String MoTa;

}
