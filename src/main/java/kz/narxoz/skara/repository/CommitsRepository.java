package kz.narxoz.skara.repository;

import kz.narxoz.skara.entity.Commits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CommitsRepository extends JpaRepository<Commits, Long> {

  List<Commits> findByPostId(Long id);
}
