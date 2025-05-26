package Stage2_070425_060625.Homework6.repository;

import Stage2_070425_060625.Homework6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Мы не пишем вручную реализацию (методы findAll, save, deleteById, findById, и т.д.). Spring автоматически создаёт реализацию этого интерфейса во время запуска. В Spring Data JPA — описываешь, что хочешь, реализация будет за тебя.
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
