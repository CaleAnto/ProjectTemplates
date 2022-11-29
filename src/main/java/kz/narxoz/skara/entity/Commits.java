package kz.narxoz.skara.entity;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "commits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Commits {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "data")
  private String data;

  @Column(name = "text")
  private String text;

  @Column(name = "rate")
  private int rate;

  @Column(name = "postId")
  private Long postId;

}
