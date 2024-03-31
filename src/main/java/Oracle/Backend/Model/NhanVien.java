package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNV",nullable = false,unique = true)
    private int id;
    @Column(name = "TenNV",columnDefinition = "nvarchar2(40)")
    private String TenNV;
    private DATE NgaySinh;
    @Column(name="Email",columnDefinition = "nvarchar2(50)",unique = true)
    private String Email;
    @Column(name="SDT",columnDefinition = "nvarchar2(14)",unique = true)
    private String SDT;
}
