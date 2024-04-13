package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TacGia")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTacGia")
    private int id;
    @Column(columnDefinition = "nvarchar2(40)")
   private String tenTacGia;
    @Column(columnDefinition = "number(4,0)")
    private int namSinh;
    @Column(columnDefinition = "number(4,0)")
    private int namMat;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "DauSach_tacGiaList",
            joinColumns = @JoinColumn(name = "TacGia_MaTacGia"),
            inverseJoinColumns = @JoinColumn(name = "DauSach_MaDauSach"))

    private List<DauSach> dauSachList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getNamMat() {
        return namMat;
    }

    public void setNamMat(int namMat) {
        this.namMat = namMat;
    }

    public List<DauSach> getDauSachList() {
        return dauSachList;
    }

    public void setDauSachList(List<DauSach> dauSachList) {
        this.dauSachList = dauSachList;
    }
}
