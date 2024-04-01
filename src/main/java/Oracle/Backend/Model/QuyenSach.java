package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(columnDefinition = "smallint")
    private int gia;

}
