package com.xiaobai.information.service;

import com.xiaobai.information.model.dto.RecordDTO;
import com.xiaobai.information.model.entity.Record;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RecordService {
    RecordDTO findById(Integer id);

    List<RecordDTO> getRecordByUserId(String openId);

    RecordDTO delete(Integer id);

    RecordDTO save(Record record);

    List<RecordDTO> findByPage(PageRequest of);

    List<RecordDTO> getRecordLike(String param);

    long getCount();
}
