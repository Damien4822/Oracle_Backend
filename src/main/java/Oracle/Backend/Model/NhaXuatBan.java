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
    private String TenNXB;
    @Column(columnDefinition = "nvarchar2(60)")
    private String DiaChi;
    @Column(columnDefinition = "nvarchar2(14)")
    private String SDT;
    @Column(columnDefinition = "nvarchar2(50)")
    private String Email;
}
