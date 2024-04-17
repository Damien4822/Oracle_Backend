package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class QuyenSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaQuyenSach")
    private int id;
    @Column(columnDefinition = "number(4,0)")
    private int namTaiBan;
    @Column(columnDefinition = "integer")
    private int gia;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "MaDauSach",nullable = false)
    private DauSach dauSach;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "MaNXB",nullable = false)
    private NhaXuatBan nhaXuatBan;
    @ManyToMany(mappedBy = "quyenSachList",fetch = FetchType.EAGER)
    private List<DichGia> dichGiaList;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MaTinhTrang",nullable = false)
    private TinhTrangSach tinhTrangSach;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNamTaiBan() {
        return namTaiBan;
    }

    public void setNamTaiBan(int namTaiBan) {
        this.namTaiBan = namTaiBan;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public DauSach getDauSach() {
        return dauSach;
    }

    public void setDauSach(DauSach dauSach) {
        this.dauSach = dauSach;
    }

    public NhaXuatBan getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public List<DichGia> getDichGiaList() {
        return dichGiaList;
    }

    public void setDichGiaList(List<DichGia> dichGiaList) {
        this.dichGiaList = dichGiaList;
    }

    public TinhTrangSach getTinhTrangSach() {
        return tinhTrangSach;
    }

    public void setTinhTrangSach(TinhTrangSach tinhTrangSach) {
        this.tinhTrangSach = tinhTrangSach;
    }
}
