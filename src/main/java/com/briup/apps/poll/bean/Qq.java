package com.briup.apps.poll.bean;

public class Qq {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_qq.id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_qq.questionnaire_id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    private Long questionnaireId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_qq.question_id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    private Long questionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_qq.id
     *
     * @return the value of poll_qq.id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_qq.id
     *
     * @param id the value for poll_qq.id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_qq.questionnaire_id
     *
     * @return the value of poll_qq.questionnaire_id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_qq.questionnaire_id
     *
     * @param questionnaireId the value for poll_qq.questionnaire_id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_qq.question_id
     *
     * @return the value of poll_qq.question_id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_qq.question_id
     *
     * @param questionId the value for poll_qq.question_id
     *
     * @mbg.generated Tue Jun 26 11:18:45 CST 2018
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}