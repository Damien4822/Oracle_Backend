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
    private String tenDichGia;
    @Nullable
    @Column(columnDefinition = "number(4,0)")
    private int namSinh;
    @Nullable
    @Column(columnDefinition = "number(4,0)")
    private Date namMat;
    @ManyToMany
    @JoinTable(
            name = "QuyenSach_dichGiaList",
            joinColumns = @JoinColumn(name = "DichGia_MaDichGia"),
            inverseJoinColumns = @JoinColumn(name = "QuyenSach_MaQuyenSach"))
    private List<QuyenSach> quyenSachList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDichGia() {
        return tenDichGia;
    }

    public void setTenDichGia(String tenDichGia) {
        this.tenDichGia = tenDichGia;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    @Nullable
    public Date getNamMat() {
        return namMat;
    }

    public void setNamMat(@Nullable Date namMat) {
        this.namMat = namMat;
    }

    public List<QuyenSach> getQuyenSachList() {
        return quyenSachList;
    }

    public void setQuyenSachList(List<QuyenSach> quyenSachList) {
        this.quyenSachList = quyenSachList;
    }
}
