package com.kchauntell.KaosCtrl_Backend.Services.BoardServices;

import com.kchauntell.KaosCtrl_Backend.DAO.BoardRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.BoardStatus;
import com.kchauntell.KaosCtrl_Backend.Entity.Boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BoardApplicationImplementation implements BoardApplication{
    @Autowired
    public BoardRepository boardRepository;

    public BoardApplicationImplementation(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Boards> getAllBoards() {
        return this.boardRepository.findAll();
    }

    @Override
    public Optional<Boards> getBoardById(int id) {
        return this.boardRepository.findById((int) id);
    }

    @Override
    public Optional<Boards> getBoardByName(String name) {
        return this.boardRepository.findByName(name);
    }

    @Override
    public BoardStatus createBoard(Boards newBoard) {
        Optional<Boards> boardToCreate = this.getBoardByName(newBoard.getName());
        if(boardToCreate.isPresent()) {
            System.out.println("Board already exists");
            return BoardStatus.BOARD_ALREADY_EXISTS;
        }
        this.boardRepository.save(newBoard);
        return BoardStatus.BOARD_SUCCESS;
    }

    @Override
    public Boards updateBoard(Boards board) throws Exception {
        Optional<Boards> boardToUpdateOptional = this.getBoardById(board.getBoard_id());
        if(boardToUpdateOptional.isEmpty()) {
            return null;
        }

        Boards boardToUpdate = boardToUpdateOptional.get();

        if(board.getName() != null) {
            boardToUpdate.setName(board.getName());
        }
        if(board.getDescription() != null) {
            boardToUpdate.setDescription(board.getDescription());
        }
        boardToUpdate.setUpdatedAt(LocalDateTime.now());
        return this.boardRepository.save(boardToUpdate);
    }

    @Override
    public void deleteBoard(Boards board) throws Exception {
        int board_id = board.getBoard_id();

        Optional<Boards> boardToDeleteOptional = this.getBoardById(board_id);
        if(boardToDeleteOptional.isEmpty()) {
            throw new Exception("Board does not exist");
        }

        Boards boardToDelete = boardToDeleteOptional.get();
        this.boardRepository.delete(boardToDelete);
    }
}
