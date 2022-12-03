package kz.narxoz.skara.repository;

import kz.narxoz.skara.entity.Statia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatiaRepository extends JpaRepository<Statia, Long> {

  Statia getByImg1(Long id);

  Statia getByImg2(Long id);

  Statia getByList1(Long id);

  Statia getByList2(Long id);

  Statia getByList3(Long id);

  Statia getByList4(Long id);

  Statia getByText1(Long id);

  Statia getByText2(Long id);

  Statia getByText3(Long id);

  Statia getByText4(Long id);

  Statia getByText5(Long id);

  Statia getByTitle1(Long id);

  Statia getByTitle2(Long id);

  Statia getByTitle3(Long id);

  Statia getByTitle4(Long id);

  Statia getByTitle5(Long id);

}
