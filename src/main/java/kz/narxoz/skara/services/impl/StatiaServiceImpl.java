package kz.narxoz.skara.services.impl;

import kz.narxoz.skara.entity.Statia;
import kz.narxoz.skara.repository.StatiaRepository;
import kz.narxoz.skara.services.StatiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatiaServiceImpl implements StatiaService {

  @Autowired
  StatiaRepository statiaRepository;

  @Override
  public Statia getStatia(Long id){
    return statiaRepository.findById(id).orElse(null);
  }

  @Override
  public Statia createStatia(Statia statia){
    return statiaRepository.save(statia);
  }

}
