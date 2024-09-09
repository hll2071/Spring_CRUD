package gomdoliro.practice.controller.dto;

import gomdoliro.practice.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SaveBoardResponse {
    private Long id;
    private String title;
    private String content;

    public SaveBoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
