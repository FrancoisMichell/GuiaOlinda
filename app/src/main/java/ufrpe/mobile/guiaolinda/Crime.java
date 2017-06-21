package ufrpe.mobile.guiaolinda;

import java.util.Date;
import java.util.UUID;

class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    UUID getId() {
        return mId;
    }

    String getTitle() {
        return mTitle;
    }

    void setTitle(String title) {
        mTitle = title;
    }

    Date getDate() {
        return mDate;
    }

    void setDate(Date date) {
        mDate = date;
    }

    boolean isSolved() {
        return mSolved;
    }

    void setSolved(boolean solved) {
        mSolved = solved;
    }
}
