package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NhaXuatBan")
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNXB")
    private int id;
    @Column(columnDefinition = "nvarchar2(40)")
    private String tenNXB;
    @Column(columnDefinition = "nvarchar2(300)")
    private String diaChi;
    @Column(columnDefinition = "nvarchar2(14)")
    private String sdt;
    @Column(columnDefinition = "nvarchar2(50)")
    private String email;
}
