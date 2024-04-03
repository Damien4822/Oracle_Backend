package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QuyenSach")
public class QuyenSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaQuyenSach")
    private int id;
    @Column(columnDefinition = "number(4,0)")
    private int NamTaiBan;
    @Column(columnDefinition = "integer")
    private int gia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaDauSach",nullable = false)
    @JsonIgnore
    private DauSach dauSach;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaNXB",nullable = false)
    @JsonIgnore
    private NhaXuatBan nhaXuatBan;
    @ManyToMany(mappedBy = "quyenSachList")
    @JsonIgnore
    private List<DichGia> dichGiaList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaTinhTrang",nullable = false)
    @JsonIgnore
    private TinhTrangSach tinhTrangSach;

}
