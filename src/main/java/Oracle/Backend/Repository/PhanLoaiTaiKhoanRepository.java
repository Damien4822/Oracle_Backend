package Oracle.Backend.Repository;

import Oracle.Backend.Model.PhanLoaiTaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanLoaiTaiKhoanRepository extends JpaRepository<PhanLoaiTaiKhoan,Integer> {
    PhanLoaiTaiKhoan findPhanLoaiTaiKhoanById(int id);
}
