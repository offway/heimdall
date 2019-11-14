package cn.offway.heimdall.service;


import java.util.List;

import cn.offway.heimdall.domain.PhReadcode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 阅读码购买使用表Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-10-29 15:52:21 Exp $
 */
public interface PhReadcodeService{

    PhReadcode save(PhReadcode phReadcode);
	
    PhReadcode findOne(Long id);

    void delete(Long id);

    List<PhReadcode> save(List<PhReadcode> entities);

    List<PhReadcode> findAllBybuyersid(Long id);

    List<PhReadcode> findByUseridCode(Long id);

    Page<PhReadcode> findByBuyersIdAndBooksId(String state,Long userid, Long id, Pageable page);

    PhReadcode findByUseIdAndBooksIdAndState(Long userid, Long booksid, String state);

    PhReadcode findByBooksIdAndStateAndUseIdAndCode(Long booksid, String state, Long userid, String code);

    List<PhReadcode> findByBooksIdAndStateAndUseId(Long booksid, String state, Long userid);
}
