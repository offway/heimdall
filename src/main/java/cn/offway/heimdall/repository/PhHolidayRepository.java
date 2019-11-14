package cn.offway.heimdall.repository;

import java.util.Date;

import cn.offway.heimdall.domain.PhHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhHoliday;

/**
 * 节假日Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhHolidayRepository extends JpaRepository<PhHoliday,Long>,JpaSpecificationExecutor<PhHoliday> {

	int countByHoliday(Date holiday);
}
