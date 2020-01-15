package com.xiaobai.information.respository;

import com.xiaobai.information.model.entity.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author XinHuiChen
 */
public interface RecordRepository extends PagingAndSortingRepository<Record, Integer> {
    /**
     * @param title
     * @return
     */
    @Query(value = "select * from t_record where title like ?1%", nativeQuery = true)
    List<Record> getRecordLike(String title);

    /**
     * @param openId
     * @return
     */
    @Query(value = "select * from t_record where user_id = ?1", nativeQuery = true)
    List<Record> getRecordByUserId(String openId);
}
