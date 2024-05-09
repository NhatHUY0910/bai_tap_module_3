package com.thi_thuc_hanh.model.entity;

import java.util.Date;

public class LibraryCard {
    private int id;
    private int book_id;
    private int student_id;
    private boolean status;
    private Date check_out_date;
    private Date check_in_date;

    public LibraryCard() {
    }

    public LibraryCard(int id) {
        this.id = id;
    }

    public LibraryCard(int book_id, int student_id, boolean status, Date check_out_date, Date check_in_date) {
        this.book_id = book_id;
        this.student_id = student_id;
        this.status = status;
        this.check_out_date = check_out_date;
        this.check_in_date = check_in_date;
    }

    public LibraryCard(int id, int book_id, int student_id, boolean status, Date check_out_date, Date check_in_date) {
        this.id = id;
        this.book_id = book_id;
        this.student_id = student_id;
        this.status = status;
        this.check_out_date = check_out_date;
        this.check_in_date = check_in_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(Date check_out_date) {
        this.check_out_date = check_out_date;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }
}
