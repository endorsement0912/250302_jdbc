package com.grepp.jdbc.app.book.validator;

import com.grepp.jdbc.app.book.dto.form.RegistForm;
import com.grepp.jdbc.infra.db.JdbcTemplate;
import com.grepp.jdbc.infra.exception.ValidException;
import com.grepp.jdbc.infra.validator.Validator;
import java.sql.Connection;
import java.util.Optional;

public class RegistFormValidator implements Validator<RegistForm> {

  private final BookDao bookDao = new BookDao();
  private final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

  @Override
  public void validate(RegistForm form) {
    if (form == null) {
      throw new ValidException("도서 등록 폼이 제공되지 않았습니다.");
    }

    Connection conn = jdbcTemplate.getConnection(); //DB에 접속하기 위한 Connection 객체를 반환
    Optional<BookDto> book = bookDao.selectById(conn, form.getIsbn());

    book.ifPresent(e->{
      throw new ValidException("중복된 도서번호 입니다.");
    });

    if(form.getTitle() == null || form.getTitle().isBlank()){
      throw new ValidException("도서명은 공백일 수 없습니다.");
    }

    if(form.getAuthor() == null || form.getAuthor().isBlank()){
      throw new ValidException("작가명은 공백일 수 없습니다.");
    }

    if(form.getCategory() == null || form.getCategory().isBlank()){
      throw new ValidException("카테고리는 공백일 수 없습니다.");
    }

    if(form.getAmount() == null || form.getAmount().length() < 0 ){
      throw new ValidException("도서 보유 재고는 1개보다 작을 수 없습니다.");
    }

  }
}
