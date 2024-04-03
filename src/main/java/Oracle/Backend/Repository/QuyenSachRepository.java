package Oracle.Backend.Repository;

import Oracle.Backend.Model.QuyenSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenSachRepository extends JpaRepository<QuyenSach,Integer> {
}
