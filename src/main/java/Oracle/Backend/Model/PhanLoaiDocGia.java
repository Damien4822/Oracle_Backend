package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="PhanLoaiDocGia")
public class PhanLoaiDocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhanLoaiDocGia",  nullable = false)
    private int MaPhanLoaiDocGia;
    @Column(name = "TenPhanLoai", columnDefinition = "nvarchar2(30)")
    private String TenPL;
    @Column(name = "MoTa",  columnDefinition = "nvarchar2(40)")
    private String MoTa;

    public int getMaPhanLoaiDocGia() {
        return MaPhanLoaiDocGia;
    }

    public void setMaPhanLoaiDocGia(int maPhanLoaiDocGia) {
        MaPhanLoaiDocGia = maPhanLoaiDocGia;
    }

    public String getTenPL() {
        return TenPL;
    }

    public void setTenPL(String tenPL) {
        TenPL = tenPL;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }
}
