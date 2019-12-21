package com.pri.entity;

import lombok.Data;

 /**
  * @ClassName:      TradeCentre
  * @Description:    行业中间关系实体类
  * @author:         ChenQi
  * @CreateDate:     2019/4/26 13:10
  */
import java.util.Date;
@Data
public class TradeCentre {

    private Integer id;

    /**ChenQi 2019/4/26; 行业id*/
    private Integer tradeId;

    /**ChenQi 2019/4/26; 关联表id*/
    private Integer relevanceId;

    /**ChenQi 2019/5/6; 所属微信用户*/
    private Integer WxUserId;

    /**ChenQi 2019/4/26; 类型：1.行业与资讯2.行业与名片*/
    private Integer type;

    private Date createdate;

}