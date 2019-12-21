package com.pri.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * class name:News <BR>
 * class description: 资讯（新闻）实体类 <BR>
 * Remark: <BR>
 * @version 1.00 2019年4月24日
 * @author )chenqi
 */
@Data
public class News{
    /**ChenQi 2019/4/28; 动态(资讯)表主键*/
    private Integer id;

    /**ChenQi 2019/4/28; 发起者*/
    private Integer ownerId;

    /**ChenQi 2019/4/28; 平台id*/
    private String nid;

    /**ChenQi 2019/4/28; 标题*/
    private String title;

    /**ChenQi 2019/4/28; 图片url,如果多个用','分隔，例如1,2,4*/
    private String img;

    /**ChenQi 2019/4/28; 视频url,如果多个用','分隔，例如1,2,4*/
    private String video;

    /**ChenQi 2019/4/28; 评论人数*/
    private Integer commentNum;

    /**ChenQi 2019/4/28; 点赞人数*/
    private Integer likeNum;

    /**ChenQi 2019/4/28; 收藏人数*/
    private Integer collectNum;

    /**ChenQi 2019/4/28; 类型1.资讯*/
    private Integer type;

    /**ChenQi 2019/4/28; 审核状态0.失败1.通过2.待审*/
    private Integer audit;

    /**ChenQi 2019/4/28; 审核人id*/
    private Integer auditor;

    /**ChenQi 2019/4/28; 创建时间*/
    private Date createdate;

    /**ChenQi 2019/4/28; 消息内容*/
    private String content;

    /**ChenQi 2019/4/27; 主键集合，用于行业条件查询*/
    private List<Integer> ids;

}