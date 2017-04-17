package com.photovoltaic.dao.inverter;

import com.photovoltaic.web.dto.inverter.InverterInfoDTO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by ziye on 2017/4/17.
 */
@Mapper
public interface TodaySummaryDataDAO {

    /**
     * 获取逆变器一段时间内的统计数据
     * @param inverterIdList
     * @param startDate
     * @param endDate
     * @return
     */
    @MapKey("inverterId")
    Map<String, InverterInfoDTO> getInverterInfoMapByTimeInterval(@Param("inverterIdList") List<String> inverterIdList,
                                                                @Param("startDate")String startDate,
                                                                @Param("endDate")String endDate);

}
