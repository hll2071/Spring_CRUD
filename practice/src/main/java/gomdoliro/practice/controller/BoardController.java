package gomdoliro.practice.controller;

import gomdoliro.practice.controller.dto.SaveBoardRequest;
import gomdoliro.practice.controller.dto.SaveBoardResponse;
import gomdoliro.practice.controller.dto.UpdateBoardRequest;
import gomdoliro.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/save")
    public SaveBoardResponse save(@RequestBody SaveBoardRequest request) {
        return boardService.save(request);
    }

    @GetMapping("/find-all")
    public List<SaveBoardResponse> findAll() {
        return boardService.getAll();
    }

    @GetMapping("/find/{id}")
    public SaveBoardResponse findOne(@PathVariable Long id) {
        return boardService.getOne(id);
    }

    @PutMapping("/update")
    public SaveBoardResponse update(@RequestBody UpdateBoardRequest request) {
        return boardService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}
