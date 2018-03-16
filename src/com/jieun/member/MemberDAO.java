package com.jieun.member;

import java.util.List;

public interface MemberDAO {
	//접근지정자 그외지정자 리턴타입 메서드명
	public int insert(MemberDTO memberDTO) throws Exception;
	//insert
	public int update(MemberDTO memberDTO) throws Exception;
	//update
	public int delete(int id) throws Exception;
	//delete
	public List<MemberDTO> selectList()	throws Exception;
	//selectList
	public MemberDTO selectOne(int id) throws Exception;
	//select
}
