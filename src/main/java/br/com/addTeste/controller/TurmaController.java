package br.com.addTeste.controller;

import br.com.addTeste.entity.Turma;
import br.com.addTeste.service.TurmaService;
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
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping("turma/index")
    public ModelAndView getTurmaList(){

        ModelAndView mv = new ModelAndView("/turma/turmaIndex");
        List<Turma> turmaList = this.turmaService.findAll();
        mv.addObject("turmaList", turmaList);

        return mv;
    }

    @GetMapping("turma/form/add")
    public ModelAndView getTurmaAdd(){
        ModelAndView mv = new ModelAndView("/turma/turmaAdd");
        return mv;
    }

    @PostMapping("/turma/form/salvar")
    public String salvarTurma(@Valid Turma turma, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Preencha todos os campos obrigatórios");
            return "redirect:/turma/form/add";
        }
        this.turmaService.salvar(turma);
        return "redirect:/turma/index";
    }

    @GetMapping("/turma/editar/{id}")
    public ModelAndView getEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("/turma/turmaAdd");
        List<Turma> turmaList = this.turmaService.findAll();
        mv.addObject("turmaList", turmaList);
        Turma turma = this.turmaService.findById(id);
        mv.addObject("turma", turma);

        return mv;
    }

    @GetMapping("/turma/apagar/{id}")
    public String delete(@PathVariable("id") int id){
        this.turmaService.apagar(id);
        return "redirect:/turma/index";
    }

}
