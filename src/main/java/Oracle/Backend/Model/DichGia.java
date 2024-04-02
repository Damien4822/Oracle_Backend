package Oracle.Backend.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

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
    @ManyToMany
    @JoinTable(
            name = "QuyenSach_dichGiaList",
            joinColumns = @JoinColumn(name = "DichGia_MaDichGia"),
            inverseJoinColumns = @JoinColumn(name = "QuyenSach_MaQuyenSach"))
    private List<QuyenSach> quyenSachList;
}
