package br.com.addTeste.controller;

import br.com.addTeste.entity.Aluno;
import br.com.addTeste.entity.Turma;
import br.com.addTeste.service.AlunoService;
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
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TurmaService turmaService;

    @GetMapping("/aluno/index")
    public ModelAndView geAlunoList(){
        ModelAndView mv = new ModelAndView("/aluno/alunoIndex");
        List<Aluno> alunoList = this.alunoService.findAll();
        mv.addObject("alunoList", alunoList);
        return mv;
    }

    @GetMapping("aluno/form/add")
    public ModelAndView getTurmaList() {

        ModelAndView mv = new ModelAndView("/aluno/alunoAdd");
        List<Turma> turmaList = this.turmaService.findAll();
        mv.addObject("turmaList", turmaList);

        return mv;
    }

    @PostMapping("/aluno/form/salvar")
    public String salvarAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem",
                    "Preencha todos os campos obrigatórios");
            return "redirect:/aluno/form/add";
        }

        this.alunoService.salvar(aluno);

        return "redirect:/aluno/index";
    }

    @GetMapping("/aluno/editar/{id}")
    public ModelAndView getEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("/aluno/alunoAdd");
        List<Turma> turmaList = this.turmaService.findAll();
        mv.addObject("turmaList", turmaList);
        Aluno aluno = this.alunoService.findById(id);
        mv.addObject("aluno", aluno);

        return mv;
    }

    @GetMapping("/aluno/apagar/{id}")
    public String delete(@PathVariable("id") int id){
        this.alunoService.apagar(id);
        return "redirect:/aluno/index";
    }
}
