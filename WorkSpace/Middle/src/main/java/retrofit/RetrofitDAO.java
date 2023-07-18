package retrofit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class RetrofitDAO {
	@Autowired @Qualifier("hanul")
	SqlSession sql;
	
	public List<RetrofitVO> select() {
		return sql.selectList("retrofit.select");
	}
	
	public int insert(RetrofitVO vo) {
		return sql.insert("retrofit.insert", vo);
	}
	
	public int update(RetrofitVO vo) {
		return sql.update("retrofit.update", vo);
	}
	
	public int delete(RetrofitVO vo) {
		return sql.delete("retrofit.delete", vo);
	}

}
