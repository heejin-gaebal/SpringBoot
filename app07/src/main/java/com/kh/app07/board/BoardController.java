package com.kh.app07.board;

import com.kh.app07.member.MemberVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {
    @Autowired /* 결합도를 낮추기 위해 스프링이 컨트롤러와 자동연결하게 함 */
    private BoardService boardService;

    /*게시글 작성 화면*/
    @GetMapping("insert")
    public void insert(){}

    /*게시글 작성*/
    @PostMapping("insert")
    public String insert(BoardVo vo, HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        if(loginMember == null){
            throw new IllegalStateException("[BOARD-001] login first");
        }
        vo.setWriterNo(loginMember.getNo());

        int result = boardService.insert(vo);
        return "redirect:/board/list";
    }
    
    /*게시글 목록조회*/
    @GetMapping("list")
    public void list(Model model){
        List<BoardVo> voList = boardService.getBoardList();
        model.addAttribute("voList", voList);
    };
}
