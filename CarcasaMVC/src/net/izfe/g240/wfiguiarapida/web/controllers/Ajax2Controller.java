package net.izfe.g240.wfiguiarapida.web.controllers;



import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/ajax")
@Controller
public class Ajax2Controller {

  @RequestMapping("/ver")
  public String impresionModel109(Model model, HttpServletRequest request) {

    Cuenta cuenta = new Cuenta();
    cuenta.setNombre("DA�-");
    String encoding = request.getCharacterEncoding();

    model.addAttribute("cuenta", cuenta);
    model.addAttribute("encoding", encoding);

    return "pruebaAjax";
  }

  // Cambio para hacer commit
  @RequestMapping("/generar")
  public String generar(@RequestParam(value = "cod") String cod, @RequestParam(value = "codEscape") String codEscape,
      @RequestParam(value = "codEncode") String codEncode, Model model, HttpServletRequest request) {

    String encoding = request.getCharacterEncoding();

    System.out.println("Character Encoding: " + encoding);
    System.out.println("cod=" + cod);
    System.out.println("codEscape" + codEscape);
    System.out.println("codEncode" + codEncode);

    model.addAttribute("encoding", encoding);
    model.addAttribute("cod", cod);
    model.addAttribute("codEscape", codEscape);
    model.addAttribute("codEncode", codEncode);

    Cuenta cuenta = new Cuenta();
    cuenta.setNombre(cod);
    model.addAttribute("cuenta", cuenta);

    return "pruebaAjax";
  }
}
