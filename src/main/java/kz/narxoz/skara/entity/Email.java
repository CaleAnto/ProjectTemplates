package kz.narxoz.skara.entity;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "email")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Email {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "emails")
  private String emails;

}
