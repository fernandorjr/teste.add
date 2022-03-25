package br.com.addTeste.controller;

import br.com.addTeste.entity.Endereco;
import br.com.addTeste.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("endereco/form/add")
    public ModelAndView getEnderecoAddPage() {
        ModelAndView mv = new ModelAndView("/endereco/enderecoAdd");
        return mv;
    }

    @PostMapping("/endereco/form/salvar")
    public String salvarEndereco(@Valid Endereco endereco, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem",
                    "Preencha todos os campos obrigatórios");
            return "redirect:/aluno/form/add";
        }

        this.enderecoService.salvar(endereco);

        return "redirect:/escola/index";
    }
}
