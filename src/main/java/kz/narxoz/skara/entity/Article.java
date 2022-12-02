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
  private String theme; // Тема Статьи
  @Column(name = "theme_image", nullable = false)
  private String theme_image; // Изображение Статьи
  @Column(name = "subtext", nullable = false, length = 1000)
  private String subtext; // Подзаголовок темы статьи
  @Column(name = "author", nullable = false)
  private String author; // Автор статьи
  @Column(name = "data", nullable = false)
  private String data; // Дата выставление статьи
  @Column(name = "view", nullable = false)
  private int view; // Количество просмотров ( не для вывода)
  @Column(name = "tag", nullable = false)
  private String tag; // теги статии
  @Column(name = "readtime", nullable = false)
  private int read; // время чтение статьи
  @Column(name = "id_statia", nullable = false, length = 100000)
  private String id_statia;


}
