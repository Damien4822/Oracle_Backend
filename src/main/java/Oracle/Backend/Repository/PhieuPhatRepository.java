package Oracle.Backend.Repository;

import Oracle.Backend.Model.PhieuPhat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuPhatRepository extends JpaRepository<PhieuPhat,Integer> {
}
