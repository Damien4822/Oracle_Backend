package Oracle.Backend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DauSach")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class DauSach {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "MaDauSach")
        private int id;
        @Column(columnDefinition = "nvarchar2(100)")
        private String tenDauSach;
        @Column(columnDefinition = "number (4,0)")
        private int namXuatBan;
        @ManyToMany(mappedBy = "dauSachList",fetch = FetchType.EAGER)
        @JsonBackReference
        private List<TacGia> tacGiaList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<QuyenSach> quyenSaches;

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTenDauSach() {
            return tenDauSach;
        }

        public void setTenDauSach(String tenDauSach) {
            this.tenDauSach = tenDauSach;
        }

        public int getNamXuatBan() {
            return namXuatBan;
        }

        public void setNamXuatBan(int namXuatBan) {
            this.namXuatBan = namXuatBan;
        }

        public List<TacGia> getTacGiaList() {
            return tacGiaList;
        }

        public void setTacGiaList(List<TacGia> tacGiaList) {
            this.tacGiaList = tacGiaList;
        }
}
