package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SachDienTu")
public class SachDienTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSachDT")
    private int id;
    @Lob
    private Blob noiDung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MaQuyenSach",nullable = false)
    @JsonIgnore
    private QuyenSach quyenSach;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(Blob noiDung) {
        this.noiDung = noiDung;
    }

    public QuyenSach getQuyenSach() {
        return quyenSach;
    }

    public void setQuyenSach(QuyenSach quyenSach) {
        this.quyenSach = quyenSach;
    }
}
