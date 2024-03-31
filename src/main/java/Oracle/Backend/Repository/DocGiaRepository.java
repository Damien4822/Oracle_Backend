package Oracle.Backend.Repository;

import Oracle.Backend.Model.DocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocGiaRepository extends JpaRepository<DocGia,Integer> {
}
