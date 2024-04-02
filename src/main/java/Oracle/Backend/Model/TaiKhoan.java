package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="TaiKhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTK",unique = true)
    private int MaTK;
    @Column(name="TenDangNhap",columnDefinition = "nvarchar2(40)",unique = true,nullable = false)
    private String TenDangNhap;
    @Column(name = "MatKhau",columnDefinition = "nvarchar2(30)",nullable = false)
    private String MatKhau;
    @Column(name="TinhTrang",columnDefinition = "number(1,0)",nullable = false)
    private int TinhTrang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaPLTK",nullable = false)
    @JsonIgnore
    private PhanLoaiTaiKhoan phanloai;
}
