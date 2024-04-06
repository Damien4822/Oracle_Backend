package Oracle.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name="PhanLoaiTaiKhoan")
public enum Role {
    DOCGIA,
    THUTHU,
    ADMIN
}

