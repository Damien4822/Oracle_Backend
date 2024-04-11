package Oracle.Backend.Repository;

import Oracle.Backend.Model.ChiTietPhieuPhat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietPhieuPhatRepository extends JpaRepository<ChiTietPhieuPhat,Integer> {
    List<ChiTietPhieuPhat> getAllByPhieuPhatId(int maphieuphat);
}
