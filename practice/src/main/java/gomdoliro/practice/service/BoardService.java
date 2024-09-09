package gomdoliro.practice.service;

import gomdoliro.practice.controller.dto.SaveBoardRequest;
import gomdoliro.practice.controller.dto.SaveBoardResponse;
import gomdoliro.practice.controller.dto.UpdateBoardRequest;
import gomdoliro.practice.domain.Board;
import gomdoliro.practice.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public SaveBoardResponse save(SaveBoardRequest request) {
        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        Board save = boardRepository.save(board);

        return new SaveBoardResponse(save);
    }

    public List<SaveBoardResponse> getAll() {
        return boardRepository.findAll().stream()
                .map(SaveBoardResponse::new)
                .toList();
    }

    public SaveBoardResponse getOne(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시판을 찾을 수 없습니다."));
        return new SaveBoardResponse(board);

    }

    @Transactional
    public SaveBoardResponse update(UpdateBoardRequest request) {
        Board board = boardRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판을 찾을 수 없습니다."));
        board.update(request.getTitle(),request.getContent());
        return new SaveBoardResponse(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
