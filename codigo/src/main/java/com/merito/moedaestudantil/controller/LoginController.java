package com.merito.moedaestudantil.controller;

import com.merito.moedaestudantil.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
private final LoginService loginService;

public LoginController(LoginService loginService) {
    this.loginService = loginService;
}

  @GetMapping("/login")
  public String login() {
    return "login"; 
  }

  @PostMapping("/login")
  public String Login(@RequestParam String cpf,
                        @RequestParam String senha) {
    System.out.println("Tentando login com cpf=" + cpf + ", senha=" + senha);
      return loginService.login(cpf, senha);
  }
  
}
