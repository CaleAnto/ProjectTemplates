package kz.narxoz.skara.controllers;

import java.io.IOException;
import java.nio.file.*;
import kz.narxoz.skara.entity.Statia;
import kz.narxoz.skara.services.StatiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *Статьи контроллер.
 */
@Controller
public class StatiaController {

  @Autowired
  StatiaService statiaService;
  public static String UPLOAD_DIRECTORY =
      "C:/Users/admin/Desktop/project/Skara/src/main/resources/images";

  /**
   *Получение статьи.
   */
  @GetMapping("/statia/{id}")
  public String getArticles(@PathVariable("id") Long id, Model model) {
    Statia statia = statiaService.getStatia(id);

    String list = statia.getList1();
    String[] list_array = list.split("/");
    model.addAttribute("list1", list_array);

    list = statia.getList2();
    list_array = list.split("/");
    model.addAttribute("list2", list_array);

    list = statia.getList3();
    list_array = list.split("/");
    model.addAttribute("list3", list_array);

    list = statia.getList4();
    list_array = list.split("/");
    model.addAttribute("list4", list_array);

    model.addAttribute("statia", statia);

    return null;
  }

  /**
   *Статьи формы контроллер.
   */
  @GetMapping("/form/statia")
  public String formStatia(Model model) {
    Statia statia = new Statia();
    model.addAttribute("statia", statia);
    return "add_book";
  }

  /**
   *Статьи контроллер.
   */
  @PostMapping("/form/statia/upload")
  public String uploadStatia(@ModelAttribute("statia") Statia statia,
                             @RequestParam("img1") MultipartFile image1,
                             @RequestParam("img2") MultipartFile image2) throws IOException {
    StringBuilder fileNames1 = new StringBuilder();
    Path fileNameAndPath1 = Paths.get(UPLOAD_DIRECTORY, image1.getOriginalFilename());
    fileNames1.append(image1.getOriginalFilename());
    Files.write(fileNameAndPath1, image1.getBytes());

    StringBuilder fileNames2 = new StringBuilder();
    Path fileNameAndPath2 = Paths.get(UPLOAD_DIRECTORY, image2.getOriginalFilename());
    fileNames2.append(image2.getOriginalFilename());
    Files.write(fileNameAndPath2, image2.getBytes());

    statia.setImg1(image1.getOriginalFilename());
    statia.setImg2(image2.getOriginalFilename());

    statiaService.createStatia(statia);

    return null;
  }

}
