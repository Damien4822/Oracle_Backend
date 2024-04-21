package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class DichGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDichGia")
    private int id;
    @Column(columnDefinition = "nvarchar2(40)")
    private String tenDichGia;
    @Nullable
    @Column(columnDefinition = "number(4,0)")
    private Date namSinh;
    @Nullable
    @Column(columnDefinition = "number(4,0)")
    private Date namMat;
    @Nullable
    @ManyToMany(fetch = FetchType.LAZY)
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

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
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
