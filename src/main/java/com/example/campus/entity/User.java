package com.example.campus.entity;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.UserNo
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String userno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.UserRealName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String userrealname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.UserType
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private Integer usertype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Institute
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String institute;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.IsResgister
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private Integer isresgister;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Password
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.UserName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Email
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Address
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Tel
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ClassName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private String classname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Colletion
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    private Integer colletion;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.UserNo
     *
     * @return the value of user.UserNo
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getUserno() {
        return userno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.UserNo
     *
     * @param userno the value for user.UserNo
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setUserno(String userno) {
        this.userno = userno == null ? null : userno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.UserRealName
     *
     * @return the value of user.UserRealName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getUserrealname() {
        return userrealname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.UserRealName
     *
     * @param userrealname the value for user.UserRealName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setUserrealname(String userrealname) {
        this.userrealname = userrealname == null ? null : userrealname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.UserType
     *
     * @return the value of user.UserType
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.UserType
     *
     * @param usertype the value for user.UserType
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Institute
     *
     * @return the value of user.Institute
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Institute
     *
     * @param institute the value for user.Institute
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setInstitute(String institute) {
        this.institute = institute == null ? null : institute.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.IsResgister
     *
     * @return the value of user.IsResgister
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public Integer getIsresgister() {
        return isresgister;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.IsResgister
     *
     * @param isresgister the value for user.IsResgister
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setIsresgister(Integer isresgister) {
        this.isresgister = isresgister;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Password
     *
     * @return the value of user.Password
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Password
     *
     * @param password the value for user.Password
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.UserName
     *
     * @return the value of user.UserName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.UserName
     *
     * @param username the value for user.UserName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Email
     *
     * @return the value of user.Email
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Email
     *
     * @param email the value for user.Email
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Address
     *
     * @return the value of user.Address
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Address
     *
     * @param address the value for user.Address
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Tel
     *
     * @return the value of user.Tel
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Tel
     *
     * @param tel the value for user.Tel
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ClassName
     *
     * @return the value of user.ClassName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public String getClassname() {
        return classname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ClassName
     *
     * @param classname the value for user.ClassName
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Colletion
     *
     * @return the value of user.Colletion
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public Integer getColletion() {
        return colletion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Colletion
     *
     * @param colletion the value for user.Colletion
     *
     * @mbg.generated Tue Jun 09 02:45:56 CST 2020
     */
    public void setColletion(Integer colletion) {
        this.colletion = colletion;
    }
}