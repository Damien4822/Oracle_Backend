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
    @Column(name = "MaPhanLoaiDocGia", nullable = false)
    private int maPhanLoaiDocGia;
    @Column(name = "TenPhanLoai", columnDefinition = "nvarchar2(30)")
    private String tenPL;
    @Column(name = "MoTa", columnDefinition = "nvarchar2(40)")
    private String moTa;

    public int getMaPhanLoaiDocGia() {
        return maPhanLoaiDocGia;
    }

    public void setMaPhanLoaiDocGia(int maPhanLoaiDocGia) {
        this.maPhanLoaiDocGia = maPhanLoaiDocGia;
    }

    public String getTenPL() {
        return tenPL;
    }

    public void setTenPL(String tenPL) {
        this.tenPL = tenPL;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
