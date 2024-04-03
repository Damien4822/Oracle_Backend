package Oracle.Backend.Repository;

import Oracle.Backend.Model.TinhTrangSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhTrangSachRepository extends JpaRepository<TinhTrangSach,Integer> {
}
