package team.catfarm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team.catfarm.Models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
