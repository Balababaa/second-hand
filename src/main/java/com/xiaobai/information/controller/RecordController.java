package com.xiaobai.information.controller;

import com.xiaobai.information.model.dto.RecordDTO;
import com.xiaobai.information.model.params.RecordParam;
import com.xiaobai.information.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author XinHuiChen
 */
@RestController
@RequestMapping(value = "/record")
@Slf4j
public class RecordController {

    private final RecordService recordService;

    private Long totalCount;

    public RecordController(RecordService recordService) {this.recordService = recordService;}

    @GetMapping(value = "/{id}")
    public RecordDTO record(@PathVariable Integer id) {
        return recordService.findById(id);
    }

    @GetMapping(value = "/sell/{openId}")
    public List<RecordDTO> userRecord(@PathVariable String openId) {
        return recordService.getRecordByUserId(openId);
    }

    @DeleteMapping(value = "/{id}")
    public RecordDTO delete(@PathVariable Integer id) {
        return recordService.delete(id);
    }

    @PostMapping(value = "/add")
    public RecordDTO add(@RequestBody RecordParam recordParam) {
        return recordService.save(recordParam.convertTo());
    }

    @PostMapping(value = "/update")
    public RecordDTO update(@RequestBody RecordParam recordParam) {
        return recordService.save(recordParam.convertTo());
    }

    @GetMapping(value = "/page/{page}")
    public List<RecordDTO> recordPage(@PathVariable Integer page, HttpServletResponse response) {
        totalCount = recordService.getCount();
        response.setHeader("Total-Count", totalCount.toString());
        return recordService.findByPage(PageRequest.of(page, 20));
    }

    @GetMapping(value = "/search/{param}")
    public List<RecordDTO> search(@PathVariable String param) {
        return recordService.getRecordLike(param);
    }
}
