package com.grepp.jdbc;

import com.grepp.jdbc.application.member.code.Grade;
import com.grepp.jdbc.application.member.dao.MemberDao;
import com.grepp.jdbc.application.member.dto.MemberDto;
import com.grepp.jdbc.infra.db.JdbcTemplate;

//NOTE 01 JDBC API
// JDBC : java database connectivity
// API : application programing interface
public class Run {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
    String user = "bm";
    String passowrd = "123qwe!@#";

    JdbcTemplate.init(url, user, passowrd);

    MemberDao dao = new MemberDao();
   insert(dao);
//    select(dao);
//    update(dao);
    //delete(dao);
  }

  private static void delete(MemberDao dao) {
    MemberDto dto = new MemberDto();
    dto.setUserId("test");
    System.out.println(dao.delete(dto));
  }

  // NOTE 03 SQL ingection
  private static void update(MemberDao dao) {
    MemberDto dto = new MemberDto();
    dto.setUserId("test");
    dto.setPassword("ㅋㅋㅋㅋ");
    System.out.println(dao.update(dto));
  }

  private static void select(MemberDao dao) {
    System.out.println(dao.selectByIdAndPssword("test", "9999"));
  }

  private static void insert(MemberDao dao) {
    MemberDto dto = new MemberDto();
    dto.setUserId("test");
    dto.setPassword("9999");
    dto.setEmail("haha@gmail.com");
    dto.setGrade(Grade.ROLE_ADMIN);
    dto.setTell("010-0000-0000");
    dto.setLeave(false);
    System.out.println(dao.insert(dto));
  }
}
