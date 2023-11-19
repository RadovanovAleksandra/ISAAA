package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projekat.model.Rank;

import java.util.List;
import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank, Long> {
    Optional<Rank> findByThreshold(int threshold);

    List<Rank> findAllByThresholdGreaterThanEqual(int i);
}
