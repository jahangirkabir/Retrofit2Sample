package com.jahanbabu.retrofit2sample.Model;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("date_for")
    @Expose
    private String dateFor;
    @SerializedName("fajr")
    @Expose
    private String fajr;
    @SerializedName("shurooq")
    @Expose
    private String shurooq;
    @SerializedName("dhuhr")
    @Expose
    private String dhuhr;
    @SerializedName("asr")
    @Expose
    private String asr;
    @SerializedName("maghrib")
    @Expose
    private String maghrib;
    @SerializedName("isha")
    @Expose
    private String isha;

    /**
     *
     * @return
     * The dateFor
     */
    public String getDateFor() {
        return dateFor;
    }

    /**
     *
     * @param dateFor
     * The date_for
     */
    public void setDateFor(String dateFor) {
        this.dateFor = dateFor;
    }

    /**
     *
     * @return
     * The fajr
     */
    public String getFajr() {
        return fajr;
    }

    /**
     *
     * @param fajr
     * The fajr
     */
    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    /**
     *
     * @return
     * The shurooq
     */
    public String getShurooq() {
        return shurooq;
    }

    /**
     *
     * @param shurooq
     * The shurooq
     */
    public void setShurooq(String shurooq) {
        this.shurooq = shurooq;
    }

    /**
     *
     * @return
     * The dhuhr
     */
    public String getDhuhr() {
        return dhuhr;
    }

    /**
     *
     * @param dhuhr
     * The dhuhr
     */
    public void setDhuhr(String dhuhr) {
        this.dhuhr = dhuhr;
    }

    /**
     *
     * @return
     * The asr
     */
    public String getAsr() {
        return asr;
    }

    /**
     *
     * @param asr
     * The asr
     */
    public void setAsr(String asr) {
        this.asr = asr;
    }

    /**
     *
     * @return
     * The maghrib
     */
    public String getMaghrib() {
        return maghrib;
    }

    /**
     *
     * @param maghrib
     * The maghrib
     */
    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    /**
     *
     * @return
     * The isha
     */
    public String getIsha() {
        return isha;
    }

    /**
     *
     * @param isha
     * The isha
     */
    public void setIsha(String isha) {
        this.isha = isha;
    }

    @Override
    public String toString() {
        return "Item{" +
                "dateFor='" + dateFor + '\'' +
                ", fajr='" + fajr + '\'' +
                ", shurooq='" + shurooq + '\'' +
                ", dhuhr='" + dhuhr + '\'' +
                ", asr='" + asr + '\'' +
                ", maghrib='" + maghrib + '\'' +
                ", isha='" + isha + '\'' +
                '}';
    }
}


