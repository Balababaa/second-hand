package com.xiaobai.information.service.impl;

import com.xiaobai.information.model.dto.RecordDTO;
import com.xiaobai.information.model.entity.Record;
import com.xiaobai.information.respository.RecordRepository;
import com.xiaobai.information.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author XinHuiChen
 */
@Service
@Slf4j
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    public RecordServiceImpl(RecordRepository recordRepository) {this.recordRepository = recordRepository;}

    @Override
    public RecordDTO findById(Integer id) {
        Record record = recordRepository.findById(id).orElse(null);
        log.info("id: [{}], record: [{}]", id, record);
        if (record == null) {
            return null;
        }
        return new RecordDTO().convertFrom(record);
    }

    @Override
    public List<RecordDTO> getRecordByUserId(String openId) {
        List<Record> records = recordRepository.getRecordByUserId(openId);
        log.info("openId: [{}], records: [{}]", openId, records);
        List<RecordDTO> recordDTOs = records.stream().map((Function<Record, RecordDTO>) record -> new RecordDTO()
                .convertFrom(record)).collect(Collectors.toList());
        return recordDTOs;
    }

    @Override
    public RecordDTO delete(Integer id) {
        Record record = recordRepository.findById(id).orElse(null);
        log.info("id: [{}], record: [{}]", id, record);
        if (record == null) {
            return null;
        }
        recordRepository.delete(record);
        return new RecordDTO().convertFrom(record);
    }


    @Override
    public RecordDTO save(Record record) {
        log.info("record: [{}]", record);
        recordRepository.save(record);
        return new RecordDTO().convertFrom(record);
    }

    @Override
    public List<RecordDTO> findByPage(PageRequest of) {
        Page<Record> recordPages = recordRepository.findAll(of);
        List<RecordDTO> recordDTOs = recordPages.stream().map((Function<Record, RecordDTO>) record -> new RecordDTO()
                .convertFrom(record)).collect(Collectors.toList());
        log.info("page: [{}], records: [{}]", of, recordDTOs);
        return recordDTOs;
    }

    @Override
    public List<RecordDTO> getRecordLike(String param) {
        List<Record> records = recordRepository.getRecordLike(param);
        log.info("param: [{}], records: [{}]", param, records);
        List<RecordDTO> recordDTOs = records.stream().map((Function<Record, RecordDTO>) record -> new RecordDTO()
                .convertFrom(record)).collect(Collectors.toList());
        return recordDTOs;
    }

    @Override
    public long getCount() {
        long count = recordRepository.count();
        log.info("count: [{}]", count);
        return count;
    }
}
