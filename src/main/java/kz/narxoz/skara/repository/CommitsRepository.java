package kz.narxoz.skara.repository;

import kz.narxoz.skara.entity.Commits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommitsRepository extends JpaRepository<Commits, Long> {

  List<Commits> findByPostId(Long id);
}
