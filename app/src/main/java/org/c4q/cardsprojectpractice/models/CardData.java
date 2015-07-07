package org.c4q.cardsprojectpractice.models;

/**
 * Created by keshwans on 6/27/15.
 */
public class CardData {

    public static final int CARD_SEQ_HOSHIKO = 0;
    public static final int CARD_SEQ_LUKE = 1;


    int studentId;


    public CardData() {

    }

    public CardData(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }


}
