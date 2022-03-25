package br.com.addTeste.controller;

import br.com.addTeste.entity.Aluno;
import br.com.addTeste.entity.Endereco;
import br.com.addTeste.entity.Escola;
import br.com.addTeste.entity.Turma;
import br.com.addTeste.service.EnderecoService;
import br.com.addTeste.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EscolaController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EscolaService escolaService;


    @GetMapping("escola/index")
    public ModelAndView getEscolaList(){

        ModelAndView mv = new ModelAndView("/escola/escolaIndex");
        List<Escola> escolaList = this.escolaService.findAll();
        mv.addObject("escolaList", escolaList);

        return mv;
    }

    @GetMapping("escola/form/add")
    public ModelAndView getEnderecoAdd() {

        ModelAndView mv = new ModelAndView("/escola/escolaAdd");
        List<Endereco> enderecoList = this.enderecoService.findAll();
        mv.addObject("enderecoList", enderecoList);

        return mv;
    }

    @PostMapping("/escola/form/salvar")
    public String salvarEscola(@Valid Escola escola, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem",
                    "Preencha todos os campos obrigatórios");
            return "redirect:/escola/form/add";
        }

        this.escolaService.salvar(escola);

        return "redirect:/escola/index";
    }

    @GetMapping("/escola/editar/{id}")
    public ModelAndView getEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("/escola/escolaAdd");
        List<Endereco> enderecoList = this.enderecoService.findAll();
        mv.addObject("enderecoList", enderecoList);

        Escola escola = this.escolaService.findById(id);
        mv.addObject("escola", escola);

        return mv;
    }

    @GetMapping("/escola/apagar/{id}")
    public String delete(@PathVariable("id") int id){
        this.escolaService.apagar(id);
        return "redirect:/escola/index";
    }
}
