package kz.narxoz.skara.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "statia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Statia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "text1")
  private String text1;

  @Column(name = "list1")
  private String list1;

  @Column(name = "title1")
  private String title1;

  @Column(name = "text2")
  private String text2;

  @Column(name = "title2")
  private String title2;

  @Column(name = "img1")
  private String img1;

  @Column(name = "list2")
  private String list2;

  @Column(name = "title3")
  private String title3;

  @Column(name = "img2")
  private String img2;

  @Column(name = "list3")
  private String list3;

  @Column(name = "title4")
  private String title4;

  @Column(name = "text3")
  private String text3;

  @Column(name = "list4")
  private String list4;

  @Column(name = "text4")
  private String text4;

  @Column(name = "title5")
  private String title5;

  @Column(name = "text5")
  private String text5;

}
