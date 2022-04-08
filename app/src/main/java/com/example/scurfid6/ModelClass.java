package com.example.scurfid6;

public class ModelClass {

    String TABLE_NAME;
    String BARCODE;
    String OLD_LOCATION2;
    String STORAGE_LOCATION2;
    String OLD_LOCATION;
    String STORAGE_LOCATION;
    String NEW_LOCATION;
    String STORAGE_AT;
    String CLIENT_ID;
    String ORDER_STATE;
    String OBJECT_ID;
    String SURAT_DATA_BARU;
    String DATE_IN;
    String DATE_OUT;
    String CODE_CHARGE;
    String CHECK_DATE;
    String CHECK_BY;
    String MEDIUM;
    String RFID;
    String LOCATION_INIT;

    public ModelClass(String TABLE_NAME, String BARCODE, String OLD_LOCATION2,
                      String STORAGE_LOCATION2, String OLD_LOCATION, String STORAGE_LOCATION,
                      String NEW_LOCATION, String STORAGE_AT, String CLIENT_ID, String ORDER_STATE,
                      String OBJECT_ID, String SURAT_DATA_BARU, String DATE_IN, String DATE_OUT,
                      String CODE_CHARGE, String CHECK_DATE, String CHECK_BY, String MEDIUM,
                      String RFID, String LOCATION_INIT) {
        this.TABLE_NAME = TABLE_NAME;
        this.BARCODE = BARCODE;
        this.OLD_LOCATION2 = OLD_LOCATION2;
        this.STORAGE_LOCATION2 = STORAGE_LOCATION2;
        this.OLD_LOCATION = OLD_LOCATION;
        this.STORAGE_LOCATION = STORAGE_LOCATION;
        this.NEW_LOCATION = NEW_LOCATION;
        this.STORAGE_AT = STORAGE_AT;
        this.CLIENT_ID = CLIENT_ID;
        this.ORDER_STATE = ORDER_STATE;
        this.OBJECT_ID = OBJECT_ID;
        this.SURAT_DATA_BARU = SURAT_DATA_BARU;
        this.DATE_IN = DATE_IN;
        this.DATE_OUT = DATE_OUT;
        this.CODE_CHARGE = CODE_CHARGE;
        this.CHECK_DATE = CHECK_DATE;
        this.CHECK_BY = CHECK_BY;
        this.MEDIUM = MEDIUM;
        this.RFID = RFID;
        this.LOCATION_INIT = LOCATION_INIT;
    }

    public ModelClass() {
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public String getBARCODE() {
        return BARCODE;
    }

    public void setBARCODE(String BARCODE) {
        this.BARCODE = BARCODE;
    }

    public String getOLD_LOCATION2() {
        return OLD_LOCATION2;
    }

    public void setOLD_LOCATION2(String OLD_LOCATION2) {
        this.OLD_LOCATION2 = OLD_LOCATION2;
    }

    public String getSTORAGE_LOCATION2() {
        return STORAGE_LOCATION2;
    }

    public void setSTORAGE_LOCATION2(String STORAGE_LOCATION2) {
        this.STORAGE_LOCATION2 = STORAGE_LOCATION2;
    }

    public String getOLD_LOCATION() {
        return OLD_LOCATION;
    }

    public void setOLD_LOCATION(String OLD_LOCATION) {
        this.OLD_LOCATION = OLD_LOCATION;
    }

    public String getSTORAGE_LOCATION() {
        return STORAGE_LOCATION;
    }

    public void setSTORAGE_LOCATION(String STORAGE_LOCATION) {
        this.STORAGE_LOCATION = STORAGE_LOCATION;
    }

    public String getNEW_LOCATION() {
        return NEW_LOCATION;
    }

    public void setNEW_LOCATION(String NEW_LOCATION) {
        this.NEW_LOCATION = NEW_LOCATION;
    }

    public String getSTORAGE_AT() {
        return STORAGE_AT;
    }

    public void setSTORAGE_AT(String STORAGE_AT) {
        this.STORAGE_AT = STORAGE_AT;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(String CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public String getORDER_STATE() {
        return ORDER_STATE;
    }

    public void setORDER_STATE(String ORDER_STATE) {
        this.ORDER_STATE = ORDER_STATE;
    }

    public String getOBJECT_ID() {
        return OBJECT_ID;
    }

    public void setOBJECT_ID(String OBJECT_ID) {
        this.OBJECT_ID = OBJECT_ID;
    }

    public String getSURAT_DATA_BARU() {
        return SURAT_DATA_BARU;
    }

    public void setSURAT_DATA_BARU(String SURAT_DATA_BARU) {
        this.SURAT_DATA_BARU = SURAT_DATA_BARU;
    }

    public String getDATE_IN() {
        return DATE_IN;
    }

    public void setDATE_IN(String DATE_IN) {
        this.DATE_IN = DATE_IN;
    }

    public String getDATE_OUT() {
        return DATE_OUT;
    }

    public void setDATE_OUT(String DATE_OUT) {
        this.DATE_OUT = DATE_OUT;
    }

    public String getCODE_CHARGE() {
        return CODE_CHARGE;
    }

    public void setCODE_CHARGE(String CODE_CHARGE) {
        this.CODE_CHARGE = CODE_CHARGE;
    }

    public String getCHECK_DATE() {
        return CHECK_DATE;
    }

    public void setCHECK_DATE(String CHECK_DATE) {
        this.CHECK_DATE = CHECK_DATE;
    }

    public String getCHECK_BY() {
        return CHECK_BY;
    }

    public void setCHECK_BY(String CHECK_BY) {
        this.CHECK_BY = CHECK_BY;
    }

    public String getMEDIUM() {
        return MEDIUM;
    }

    public void setMEDIUM(String MEDIUM) {
        this.MEDIUM = MEDIUM;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getLOCATION_INIT() {
        return LOCATION_INIT;
    }

    public void setLOCATION_INIT(String LOCATION_INIT) {
        this.LOCATION_INIT = LOCATION_INIT;
    }
}
