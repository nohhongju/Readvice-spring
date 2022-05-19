package kr.readvice.api.board.services;

import kr.readvice.api.board.domains.Article2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ArticleService {
    List<Article2> findAll();

    List<Article2> findAll(Sort sort);

    Page<Article2> findAll(Pageable pageable);

    long count();

    String delete(Article2 article);

    String save(Article2 article);
}
