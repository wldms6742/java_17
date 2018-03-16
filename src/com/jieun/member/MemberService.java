package com.jieun.member;

import java.util.List;

public interface MemberService {
	public MemberDTO selectOne(int num) throws Exception;
	public List<MemberDTO> selectList() throws Exception;
	public String insert(MemberDTO memberDTO) throws Exception;
	public String delete(int num) throws Exception;
	public String update(MemberDTO memberDTO) throws Exception;
	
}
