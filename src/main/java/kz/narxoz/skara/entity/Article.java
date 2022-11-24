package kz.narxoz.skara.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "theme", nullable = false)
  private String theme;
  @Column(name = "subtext", nullable = false, length = 1000)
  private String subtext;
  @Column(name = "author", nullable = false)
  private String author;
  @Column(name = "data", nullable = false)
  private int data;
  @Column(name = "tag", nullable = false)
  private String tag;
  @Column(name = "readtime", nullable = false)
  private int read;
  @Column(name = "url", nullable = false, length = 1000)
  private String url;




}
