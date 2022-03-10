package springboot.spring_crud_boot.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.spring_crud_boot.model.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO extends JpaRepository <User, Integer> {
}
