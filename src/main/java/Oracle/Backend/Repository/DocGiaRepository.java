package Oracle.Backend.Repository;

import Oracle.Backend.Model.DocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocGiaRepository extends JpaRepository<DocGia,Integer> {
    Optional<DocGia> findDocGiaByEmail(String email);
    Optional<DocGia> findDocGiaBySDT(String SDT);
}
