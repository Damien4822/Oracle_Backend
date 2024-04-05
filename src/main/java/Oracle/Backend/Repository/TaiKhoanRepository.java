package Oracle.Backend.Repository;

import Oracle.Backend.Model.DocGia;
import Oracle.Backend.Model.TaiKhoan;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    Optional<TaiKhoan> findTaiKhoanByTenDangNhap(String tendangnhap);
}
