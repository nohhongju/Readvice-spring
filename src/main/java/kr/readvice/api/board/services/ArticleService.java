package kr.readvice.api.board.services;

import kr.readvice.api.board.domains.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    List<Article> findAll(Sort sort);

    Page<Article> findAll(Pageable pageable);

    long count();

    String delete(Article article);

    String save(Article article);
}
