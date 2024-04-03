package Oracle.Backend.Repository;

import Oracle.Backend.Model.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuThuRepository extends JpaRepository<PhieuThu,Integer> {
}
