package com.xiaobai.information.utils;

import com.xiaobai.information.model.dto.RecordDTO;
import com.xiaobai.information.model.entity.Record;
import com.xiaobai.information.model.params.RecordParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * @author XinHuiChen
 */
@Slf4j
public class BeanUtils {

    private BeanUtils() {}

    public static void updateProperties(@NotNull Object source, @NotNull Object target) {
        Assert.notNull(source, "source object must not be null");
        Assert.notNull(target, "target object must not be null");

        if (source instanceof Record) {
            org.springframework.beans.BeanUtils.copyProperties(source, target, "images");
            String[] images = ((Record) source).getImages().split(",");
            ((RecordDTO) target).setImages(images);
        } else {
            org.springframework.beans.BeanUtils.copyProperties(source, target);
        }
    }

    public static <T> T transformFrom(@Nullable Object source, @NonNull Class<T> targetClass) {
        Assert.notNull(targetClass, "Target class must not be null");

        if (source == null) {
            return null;
        }

        T targetInstance = null;
        try {
            targetInstance = targetClass.newInstance();
            if (targetInstance instanceof Record) {
                org.springframework.beans.BeanUtils.copyProperties(source, targetInstance, "images");
                String[] images = ((RecordParam) source).getImages();
                ((Record) targetInstance).setImages(String.join(",",images));
            } else {
                org.springframework.beans.BeanUtils.copyProperties(source, targetInstance);
            }
            return targetInstance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}