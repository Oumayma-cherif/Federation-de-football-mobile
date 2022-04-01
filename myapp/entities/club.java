package com.mycompany.myapp.entities;

import java.util.Objects;

/**
 *
 * @author oumayma
 */
public class club {

    private int id;
    public String nomc;
    public String logo;
    private String descr;
    private String President;

    public club(int id, String nomc, String logo, String descr, String President) {
        this.id = id;
        this.nomc = nomc;
        this.logo = logo;
        this.descr = descr;
        this.President = President;
    }

    public club(String nomc, String logo, String descr, String President) {
        this.nomc = nomc;
        this.logo = logo;
        this.descr = descr;
        this.President = President;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public club(String nomc, String descr, String President) {
        this.nomc = nomc;
        this.descr = descr;
        this.President = President;
    }

    public club() {
    }

    public club(int id) {
        this.id = id;
    }

    public club(int id, String nomc, String descr, String President) {
        this.id = id;
        this.nomc = nomc;
        this.descr = descr;
        this.President = President;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPresident() {
        return President;
    }

    public void setPresident(String President) {
        this.President = President;
    }

    @Override
    public String toString() {
        return "serviceclub {" + "id=" + id + ", nomc=" + nomc + ", descr=" + descr + ", President=" + President + '}';
    }

}
