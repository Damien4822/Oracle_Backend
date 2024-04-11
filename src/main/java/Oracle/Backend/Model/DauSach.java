package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DauSach")
public class DauSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDauSach")
    private int id;
    @Column(columnDefinition = "nvarchar2(100)")
    private String tenDauSach;
    @Column(columnDefinition = "number (4,0)")
    private int namXuatBan;
    @ManyToMany(mappedBy = "dauSachList")
    @JsonIgnore
    private List<TacGia> tacGiaList;
}
