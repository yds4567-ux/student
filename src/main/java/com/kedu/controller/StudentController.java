import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dto.StudentDTO;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentDAO dao;
	
	@RequestMapping("/insert")
	public String insert(StudentDTO dto) throws Exception {
		dao.insert(dto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String update(StudentDTO dto) throws Exception {
		dao.update(dto);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		
		
		List<StudentDTO> lists = dao.list();
		
		model.addAttribute("lists", lists);
		
		return "list"; 
	}
	
	@RequestMapping("/delete")
	public String delete(StudentDTO dto) throws Exception{
		
		dao.delete(dto);
		
		return "redirect:/student/list";
	}
	
}
