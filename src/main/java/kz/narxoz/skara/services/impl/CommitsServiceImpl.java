package kz.narxoz.skara.services.impl;

import kz.narxoz.skara.entity.Commits;
import kz.narxoz.skara.repository.CommitsRepository;
import kz.narxoz.skara.services.CommitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitsServiceImpl implements CommitsService {

  @Autowired
  CommitsRepository commitsRepository;

  @Override
  public List<Commits> commentPost(Long id){
    List<Commits> commits = commitsRepository.findByPostId(id);
    return commits;
  }

}
