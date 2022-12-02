package kz.narxoz.skara.controllers;

import kz.narxoz.skara.services.StatiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StatiaController {

  @Autowired
  StatiaService statiaService;


  @GetMapping("/statia/{id}")
  public String getArticles(@PathVariable("id") Long id, Model model) {
    model.addAttribute("img1", statiaService.getImage1(id));
    model.addAttribute("img2", statiaService.getImage2(id));

    model.addAttribute("list1", statiaService.getList1(id));
    model.addAttribute("list2", statiaService.getList2(id));
    model.addAttribute("list3", statiaService.getList3(id));
    model.addAttribute("list4", statiaService.getList4(id));

    model.addAttribute("text1", statiaService.getText1(id));
    model.addAttribute("text2", statiaService.getText2(id));
    model.addAttribute("text3", statiaService.getText3(id));
    model.addAttribute("text4", statiaService.getText4(id));
    model.addAttribute("text5", statiaService.getText5(id));

    model.addAttribute("title1", statiaService.getTitle1(id));
    model.addAttribute("title2", statiaService.getTitle2(id));
    model.addAttribute("title3", statiaService.getTitle3(id));
    model.addAttribute("title4", statiaService.getTitle4(id));
    model.addAttribute("title5", statiaService.getTitle5(id));


    return null;
  }

}
