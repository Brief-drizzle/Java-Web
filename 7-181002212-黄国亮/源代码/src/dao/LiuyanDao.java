package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import domain.Liuyan;

@Repository("liuyanDao")
@Mapper
public interface LiuyanDao {
	public void addLiuyan(Liuyan liuyan) ;
}
