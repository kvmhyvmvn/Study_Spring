package smart.khm;

import java.util.List;

import smart.board.FileVO;
import smart.common.PageVO;

public interface KhmService {
	int khm_register(KhmVO vo); // 신규 글 저장
	PageVO khm_list(PageVO page); // 방명록 목록 조회(페이지 처리)
	KhmVO khm_info(int id); // 글 안내 조회
	int khm_update(KhmVO vo); // 글 변경 저장
	int khm_read(int id); // 조회수 증가처리
	int khm_delete(int id); // 글 삭제
	
	FileVO board_file_info(int id); // 선택한 파일정보 조회
	List<FileVO> board_file_removed(String removed); // 삭제할 파일들 정보 조회
	int board_file_delete(int id); // 선택 파일정보 삭제
	
	int khm_comment_register(KhmCommentVO vo); // 댓글 신규 저장
	int khm_comment_update(KhmCommentVO vo); // 댓글 변경 저장
	int khm_comment_delete(int id); // 댓글 삭제
	List<KhmCommentVO> khm_comment_list(int khm_id); // 댓글 목록 조회
}
