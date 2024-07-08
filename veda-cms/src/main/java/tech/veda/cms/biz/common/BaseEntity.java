package tech.veda.cms.biz.common;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Brunos
 */
@Data
public class BaseEntity implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

//  @TableField(fill = FieldFill.INSERT)
//  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private LocalDateTime createDate;

//  @TableField(fill = FieldFill.UPDATE)
//  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private LocalDateTime updateDate;

//  @TableField(fill = FieldFill.INSERT)
  @TableLogic
  private String status;
}
