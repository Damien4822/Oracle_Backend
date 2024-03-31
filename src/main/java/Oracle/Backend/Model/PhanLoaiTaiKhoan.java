package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="PhanLoaiTaiKhoan")
public class PhanLoaiTaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPLTaiKhoan",unique = true,nullable = false)
    private int MaPLTK;
    @Column(name="MoTa",columnDefinition = "nvarchar2(40)")
    private String MoTa;
}
