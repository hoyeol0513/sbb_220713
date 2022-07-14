package com.mysite.sbb.Controller;

import com.mysite.sbb.Repository.QuestionRepository;
import com.mysite.sbb.vo.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
//autowired 없이도 자동으로 생성자를 만들어줌.
@AllArgsConstructor
public class QuestionController {
    private final QuestionRepository questionRepository;

    @RequestMapping("/list")
    //@ResponseBody를 떼면 알아서 템플릿을 찾아감.
    public String showQuestions(Model model){
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
