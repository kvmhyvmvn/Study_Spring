package smart.khm;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KhmCommentVO {
	private int id, board_id;
	private String content, writer, name, writedate, profile;
}
