package team.catfarm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team.catfarm.Models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
