package Stage2_070425_060625.Homework4.repository;

import Stage2_070425_060625.Homework4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
