package Oracle.Backend.Repository;

import Oracle.Backend.Model.NhanVien;
import Oracle.Backend.Model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
    NhanVien findNhanVienByTaiKhoan(TaiKhoan tk);
}
