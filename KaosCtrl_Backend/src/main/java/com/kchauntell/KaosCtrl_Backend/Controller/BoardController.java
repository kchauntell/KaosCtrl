package com.kchauntell.KaosCtrl_Backend.Controller;

import jakarta.validation.Valid;
import com.kchauntell.KaosCtrl_Backend.DAO.BoardRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Boards;
import com.kchauntell.KaosCtrl_Backend.Entity.BoardStatus;
import com.kchauntell.KaosCtrl_Backend.Services.BoardServices.BoardApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    private BoardApplication boardApplication;

    @GetMapping("/boards")
    public List<Boards> getAllBoards() {
        return boardRepository.findAll();
    }

    @PostMapping("/createBoard")
    public BoardStatus createBoard(@RequestBody Boards board) throws Exception {
        return boardApplication.createBoard(board);
    }

    @PutMapping("/updateBoard")
    public Boards updateBoard(@RequestBody Boards board) throws Exception {
        return boardApplication.updateBoard(board);
    }

    @DeleteMapping("/deleteBoard")
    public void deleteBoard(@RequestBody Boards board) throws Exception {
        this.boardApplication.deleteBoard(board);
    }
}
