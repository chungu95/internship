package project_management.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_management.repository.model.Phase;

import java.util.List;

public interface PhaseRepository extends JpaRepository<Phase, Integer> {
}
