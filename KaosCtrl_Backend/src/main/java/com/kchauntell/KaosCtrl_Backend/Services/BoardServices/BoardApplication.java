package com.kchauntell.KaosCtrl_Backend.Services.BoardServices;

import com.kchauntell.KaosCtrl_Backend.Entity.Boards;
import com.kchauntell.KaosCtrl_Backend.Entity.BoardStatus;
import java.util.List;
import java.util.Optional;

public interface BoardApplication {
    public List<Boards> getAllBoards();
    public Optional<Boards> getBoardById(int id);
    public Optional<Boards> getBoardByName(String boardName);
    public BoardStatus createBoard(Boards board) throws Exception;
    public Boards updateBoard(Boards board) throws Exception;
    public void deleteBoard(Boards board) throws Exception;
}
