/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.fx;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * Representation of the Currency
 */
public class Currency {
    @NotNull @Size(min=3, max=3)
    private String isoCode;
    @NotNull
    private String name;
    @NotNull
    private int decimalPlaces;

    public Currency(String code, String name, int decimalPlaces) {
        this.isoCode = code;
        this.name = name;
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.isoCode);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.decimalPlaces;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Currency other = (Currency) obj;
        if (!Objects.equals(this.isoCode, other.isoCode)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.decimalPlaces != other.decimalPlaces) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Currency{" + "code=" + isoCode + ", name=" + name + ", decimalPlaces=" + decimalPlaces + '}';
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getName() {
        return name;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }
    
    
}
