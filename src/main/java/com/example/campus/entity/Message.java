package com.example.campus.entity;

import java.util.Date;

public class Message {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.Id
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.Content
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.PublishTime
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private Date publishtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.AcceptClass
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String acceptclass;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.Id
     *
     * @return the value of message.Id
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.Id
     *
     * @param id the value for message.Id
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.Content
     *
     * @return the value of message.Content
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.Content
     *
     * @param content the value for message.Content
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.PublishTime
     *
     * @return the value of message.PublishTime
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public Date getPublishtime() {
        return publishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.PublishTime
     *
     * @param publishtime the value for message.PublishTime
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.AcceptClass
     *
     * @return the value of message.AcceptClass
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getAcceptclass() {
        return acceptclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.AcceptClass
     *
     * @param acceptclass the value for message.AcceptClass
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setAcceptclass(String acceptclass) {
        this.acceptclass = acceptclass == null ? null : acceptclass.trim();
    }
}