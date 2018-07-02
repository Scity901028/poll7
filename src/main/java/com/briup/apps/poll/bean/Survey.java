package com.briup.apps.poll.bean;

public class Survey {
	
	public static final String STATUS_INIT="未开启";//刚创建
	public static final String STATUS_BEGIN="正在进行";//开启
	public static final String STATUS_NO_CHECK="未审核";//关闭课调后进入的状态
	public static final String STATUS_CHECK_PASS="审核通过";
	public static final String STATUS_CHECK_NOPASS="审核未通过";
	
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.average
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private Double average;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.status
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.code
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.surveyDate
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private String surveydate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.course_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private Long courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.clazz_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private Long clazzId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.user_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.questionnaire_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    private Long questionnaireId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.id
     *
     * @return the value of poll_survey.id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.id
     *
     * @param id the value for poll_survey.id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.average
     *
     * @return the value of poll_survey.average
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public Double getAverage() {
        return average;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.average
     *
     * @param average the value for poll_survey.average
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setAverage(Double average) {
        this.average = average;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.status
     *
     * @return the value of poll_survey.status
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.status
     *
     * @param status the value for poll_survey.status
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.code
     *
     * @return the value of poll_survey.code
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.code
     *
     * @param code the value for poll_survey.code
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.surveyDate
     *
     * @return the value of poll_survey.surveyDate
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public String getSurveydate() {
        return surveydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.surveyDate
     *
     * @param surveydate the value for poll_survey.surveyDate
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setSurveydate(String surveydate) {
        this.surveydate = surveydate == null ? null : surveydate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.course_id
     *
     * @return the value of poll_survey.course_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.course_id
     *
     * @param courseId the value for poll_survey.course_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.clazz_id
     *
     * @return the value of poll_survey.clazz_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public Long getClazzId() {
        return clazzId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.clazz_id
     *
     * @param clazzId the value for poll_survey.clazz_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.user_id
     *
     * @return the value of poll_survey.user_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.user_id
     *
     * @param userId the value for poll_survey.user_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.questionnaire_id
     *
     * @return the value of poll_survey.questionnaire_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.questionnaire_id
     *
     * @param questionnaireId the value for poll_survey.questionnaire_id
     *
     * @mbg.generated Mon Jul 02 17:00:45 CST 2018
     */
    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}