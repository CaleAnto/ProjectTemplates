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
  public Statia getImage1(Long id){
    return statiaRepository.getByImg1(id);
  }

  @Override
  public Statia getImage2(Long id){
    return statiaRepository.getByImg2(id);
  }

  @Override
  public Statia getList1(Long id){
    return statiaRepository.getByList1(id);
  }

  @Override
  public Statia getList2(Long id){
    return statiaRepository.getByList2(id);
  }

  @Override
  public Statia getList3(Long id){
    return statiaRepository.getByList3(id);
  }

  @Override
  public Statia getList4(Long id){
    return statiaRepository.getByList4(id);
  }

  @Override
  public Statia getText1(Long id) {
    return statiaRepository.getByText1(id);
  }

  @Override
  public Statia getText2(Long id) {
    return statiaRepository.getByText2(id);
  }

  @Override
  public Statia getText3(Long id) {
    return statiaRepository.getByText3(id);
  }

  @Override
  public Statia getText4(Long id) {
    return statiaRepository.getByText4(id);
  }

  @Override
  public Statia getText5(Long id) {
    return statiaRepository.getByText5(id);
  }

  @Override
  public Statia getTitle1(Long id) {
    return statiaRepository.getByTitle1(id);
  }

  @Override
  public Statia getTitle2(Long id) {
    return statiaRepository.getByTitle2(id);
  }

  @Override
  public Statia getTitle3(Long id) {
    return statiaRepository.getByTitle3(id);
  }

  @Override
  public Statia getTitle4(Long id) {
    return statiaRepository.getByTitle4(id);
  }

  @Override
  public Statia getTitle5(Long id) {
    return statiaRepository.getByTitle5(id);
  }



}
