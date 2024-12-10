package cartservice.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@Getter
@Setter
@Entity
public class UserDetails extends BaseModels {
    private long userId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPassword;
}
