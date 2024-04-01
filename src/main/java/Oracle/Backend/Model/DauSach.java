package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DauSach")
public class DauSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDauSach")
    private int id;
    @Column(columnDefinition = "nvarchar2(100)")
    private String TenDauSach;
    @Column(columnDefinition = "number (4,0)")
    private int NamXuatBan;

}
