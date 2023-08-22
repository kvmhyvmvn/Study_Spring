package smart.khm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import smart.board.FileVO;
import smart.common.PageVO;

@Repository
public class KhmDAO implements KhmService {
	@Autowired @Qualifier("hanul") private SqlSession sql;

	@Override
	public int khm_register(KhmVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageVO khm_list(PageVO page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhmVO khm_info(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int khm_update(KhmVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int khm_read(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int khm_delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FileVO board_file_info(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileVO> board_file_removed(String removed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int board_file_delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int khm_comment_register(KhmCommentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int khm_comment_update(KhmCommentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int khm_comment_delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<KhmCommentVO> khm_comment_list(int khm_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
