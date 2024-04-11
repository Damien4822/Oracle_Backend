package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany
    @JoinTable(
            name = "DauSach_tacGiaList",
            joinColumns = @JoinColumn(name = "TacGia_MaTacGia"),
            inverseJoinColumns = @JoinColumn(name = "DauSach_MaDauSach"))
    private List<DauSach> dauSachList;
}
