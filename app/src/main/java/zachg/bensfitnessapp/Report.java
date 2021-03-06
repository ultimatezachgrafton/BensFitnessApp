package zachg.bensfitnessapp;

import java.util.Date;
import java.util.UUID;

// Report is the class that will comprise the individual reports from clients

public class Report {

    private UUID mId; // unique ID
    private Date mDate; // date of report
    private String mClient; // client's name
    private String mWeight; // client's weight
    // box for questions for Ben
    // photos to include with questions

    // This constructor generates a universally unique ID, then initializes it as well as the Date field
    public Report() {
            this(UUID.randomUUID());
        }
        public Report(UUID id) {
            mId = id;
            mDate = new Date();
        }

    // Setters and getters
    public UUID getId() {
            return mId;
        }

    public Date getDate() {
            return mDate;
        }

    public void setDate(Date date) {
            mDate = date;
        }

    public String getClient() { return mClient; }

    public void setClient(String client) { mClient = client; }

    public String getPhotoFilename() { return "IMG_" + getId().toString() + ".jpg"; }

    public String getWeight() { return mWeight; }

    public void setWeight(String weight) { mWeight = weight; }

}