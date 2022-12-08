package kz.narxoz.skara.services;

import kz.narxoz.skara.entity.Statia;

public interface StatiaService {


  Statia getStatia(Long id);

  Statia createStatia(Statia statia);
}
