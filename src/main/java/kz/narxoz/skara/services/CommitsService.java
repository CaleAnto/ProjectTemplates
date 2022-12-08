package kz.narxoz.skara.services;

import kz.narxoz.skara.entity.Commits;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommitsService {
  List<Commits> commentPost(Long id);

  Commits saveComments(Commits commits);

  void deleteComment(Long id);
}
